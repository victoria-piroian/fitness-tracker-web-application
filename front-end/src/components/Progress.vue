<template>
  <div class="hello">
    <img alt="Progress" src="https://i.ibb.co/thzRdmx/progress-banner.png" height="50">
    <p></p>

    <b-button class="add-button" v-b-modal.add-modal>
        <b-icon-plus-circle></b-icon-plus-circle>
      </b-button>
    <p></p>
      <b-modal id="add-modal" ref="add-modal" title="Add Progress" @hide="resetEditModal" hide-footer>
      <b-form>

        <label class="sr-only" for="input-clientId">Client ID</label>
        <b-form-input
          id='input-clientId'
          v-model="form.clientId"
          placeholder="Client Id"
          required
        ></b-form-input>

        <label class="sr-only" for="input-progressId">Progress ID</label>
        <b-form-input
          id='input-progressId'
          v-model="form.progressId"
          placeholder="Progress Id"
          required
        ></b-form-input>

        <label class="sr-only" for="input-goal">Goal</label>
        <b-form-input
          id='input-goal'
          v-model="form.goal"
          placeholder="Goal"
          required
        ></b-form-input>

        <label class="sr-only" for="input-progressScore">Progress Score</label>
        <b-form-input
          id="input-progressScore"
          v-model="form.progressScore"
          placeholder="Progress Score"
          required
        ></b-form-input>

        <label class="sr-only" for="input-reflection">Reflection</label>
        <b-form-input
          id="input-reflection"
          v-model="form.reflection"
          placeholder="Reflection"
          required
        ></b-form-input>

          <br />
          <b-button type="button" @click="onAdd" variant="primary">Add</b-button>
        </b-form>
      </b-modal>

    <div class="search-container">
      <b-input-group>
        <b-form-input type="text" placeholder="Search Goal" v-model="query"/>
        <template #append>
          <b-button class="search-button" @click="search(query)">
            <b-icon-search></b-icon-search>
          </b-button>
        </template>
      </b-input-group>
    </div>

    <b-table striped hover responsive :items="progress" :fields="fields">
      <template #cell(actions)="row">
        <b-button size="sm" v-b-modal.edit-modal @click="edit(row.item, row.index, $event.target)">
          Edit
        </b-button>
      </template>
    </b-table>
    <b-modal id="edit-modal" title="Edit Progress" @hide="resetEditModal" hide-footer>
      <b-form>

        <label class="sr-only" for="input-clientId">Client ID</label>
        <b-form-input
          id='input-clientId'
          v-model="form.clientId"
          placeholder="Client Id"
          readonly
        ></b-form-input>

        <label class="sr-only" for="input-progressId">Progress ID</label>
        <b-form-input
          id='input-progressId'
          v-model="form.progressId"
          placeholder="Progress Id"
          readonly
        ></b-form-input>

        <label class="sr-only" for="input-goal">Goal</label>
        <b-form-input
          id='input-goal'
          v-model="form.goal"
          placeholder="Goal"
          required
        ></b-form-input>

        <label class="sr-only" for="input-progressScore">Progress Score</label>
        <b-form-input
          id="input-progressScore"
          v-model="form.progressScore"
          placeholder="Progress Score"
          required
        ></b-form-input>

        <label class="sr-only" for="input-reflection">Reflection</label>
        <b-form-input
          id="input-reflection"
          v-model="form.reflection"
          placeholder="Reflection"
          required
        ></b-form-input>

        
        <br />
        <b-button type="button" @click="onSave" variant="primary">Save</b-button>
        <b-button type="reset" variant="warning">Reset</b-button>
        <b-button type="button" @click="onDelete" variant="danger">Remove Progress</b-button>
      </b-form>

    </b-modal>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'HelloWorld',
  data () {
    return {
      progress: null,
      query: '',
      fields: [
      {key: 'userProgressKey.clientId', label: 'Client ID', sortable: true},
      {key: 'userProgressKey.progressId', label: 'Progress ID', sortable: true},
      {key: 'goal', label: 'Goal', sortable: true},
      {key: 'progressScore', label: 'Progress Score', sortable: true},
      {key: 'reflection', label: 'Reflection', sortable: true},
      {key: 'actions', label: 'Actions'}],
      form: {
          clientId: '',
          progressId: '',
          goal: '',
          progressScore: '',
          reflection: ''
        },
    }
  },
  mounted () {
    this.init();
  },
  methods: {
    init() {
      axios
        .get('http://localhost:8085/progress')
        .then(response => (this.progress = response.data))
    },
    search(seachTerm){
      if (seachTerm){
        axios
        .get('http://localhost:8085/progress/search/'+seachTerm)
        .then(response => (this.progress = response.data))
        .catch(function(error){
          if (error.response){
            console.log(error.response.data);
          }
        })
      }
      console.log(seachTerm)
    },
    edit(item, index, button) {
      this.form.clientId = item.userProgressKey.clientId
      this.form.progressId = item.userProgressKey.progressId
      this.form.goal = item.goal
      this.form.progressScore = item.progressScore
      this.form.reflection = item.reflection
      
    },
    resetEditModal() {
      this.form.clientId =''
      this.form.progressId = ''
      this.form.goal =''
      this.form.progressScore =''
      this.form.reflection =''
    },
    onSave(event) {
      var progress;
      var client;
      progress = (this.form.progressId)
      client = parseInt(this.form.clientId)
      axios
        .put('http://localhost:8085/progress/' + client +'/' + progress, {
          "goal": this.form.goal,
          "progressScore": this.form.progressScore,
          "reflection": this.form.reflection,
        })
        .then(() => this.init())
        .catch(function (error) {
          console.log(error);
        });
    },
    onDelete(event) {
      var progress;
      var client;
      progress = (this.form.progressId)
      client = parseInt(this.form.clientId)
        axios
          .delete('http://localhost:8085/progress/'  + client +'/' + progress)
          .then(() => this.init())
          .catch(function (error) {
            console.log(error);
          })
    },
    onAdd(event) {
      axios
        .post('http://localhost:8085/progress', {
          "userProgressKey": {
            "clientId": this.form.clientId,
            "progressId": this.form.progressId,
          },
          "goal": this.form.goal,
          "progressScore": this.form.progressScore,
          "reflection": this.form.reflection,
        })
        .then(() => {this.init();this.$refs['add-modal'].hide()})
        .catch(function (error) {
          console.log(error);
        });
      }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}


.add-button{
    background-color: transparent;
    color: #42b983;
    border-color: #04AA6D;
  }
  .add-button:hover{
    background-color: #42b983;
    color: white;
  }
</style>
