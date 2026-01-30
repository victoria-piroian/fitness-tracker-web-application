<template>
  <div class="hello">
    <img alt="Exercises" src="https://i.ibb.co/Lh30fs8/exercise-banner.png" height="50">
    <p></p>

    <b-button class="add-button" v-b-modal.add-modal>
        <b-icon-plus-circle></b-icon-plus-circle>
      </b-button>
    <p></p>
      <b-modal id="add-modal" ref="add-modal" title="Add Workout" @hide="resetEditModal" hide-footer>
      <b-form>
  
        <label class="sr-only" for="input-clientId">Client ID</label>
        <b-form-input
          id='input-clientId'
          v-model="form.clientId"
          placeholder="Client Id"
          required
        ></b-form-input>

        <label class="sr-only" for="input-workoutId">Workout ID</label>
        <b-form-input
          id='input-workoutId'
          v-model="form.workoutId"
          placeholder="Workout Id"
          required
        ></b-form-input>

        <label class="sr-only" for="input-dayYear">Date</label>
        <b-form-input
          id='input-dayYear'
          v-model="form.dayYear"
          placeholder="Date"
          required
        ></b-form-input>

        <label class="sr-only" for="input-workoutName">Workout Name</label>
        <b-form-input
          id='input-workoutName'
          v-model="form.workoutName"
          placeholder="Workout Name"
          required
        ></b-form-input>

        <label class="sr-only" for="input-duration">Duration</label>
        <b-form-input
          id="input-duration"
          v-model="form.duration"
          placeholder="Duration"
          required
        ></b-form-input>

        <label class="sr-only" for="input-satisfaction">Satisfaction</label>
        <b-form-input
          id="input-satisfaction"
          v-model="form.satisfaction"
          placeholder="Satisfaction"
          required
        ></b-form-input>
          
          <br />
          <b-button type="button" @click="onAdd" variant="primary">Add</b-button>
        </b-form>
      </b-modal>

    <div class="search-container">
      <b-input-group>
        <b-form-input type="text" placeholder="Search Workout Name" v-model="query"/>
        <template #append>
          <b-button class="search-button" @click="search(query)">
            <b-icon-search></b-icon-search>
          </b-button>
        </template>
      </b-input-group>
    </div>


    <b-table striped hover responsive :items="exercise" :fields="fields">
      <template #cell(actions)="row">
        <b-button size="sm" v-b-modal.edit-modal @click="edit(row.item, row.index, $event.target)">
          Edit
        </b-button>
      </template>
    </b-table>
    <b-modal id="edit-modal" title="Edit Exercises" @hide="resetEditModal" hide-footer>
      <b-form>

        <label class="sr-only" for="input-clientId">Client ID</label>
        <b-form-input
          id='input-clientId'
          v-model="form.clientId"
          placeholder="Client Id"
          readonly
        ></b-form-input>

        <label class="sr-only" for="input-workoutId">Workout ID</label>
        <b-form-input
          id='input-workoutId'
          v-model="form.workoutId"
          placeholder="Workout Id"
          readonly
        ></b-form-input>

        <label class="sr-only" for="input-dayYear">Date</label>
        <b-form-input
          id='input-dayYear'
          v-model="form.dayYear"
          placeholder="Date"
          readonly
        ></b-form-input>

        <label class="sr-only" for="input-workoutName">Workout Name</label>
        <b-form-input
          id='input-workoutName'
          v-model="form.workoutName"
          placeholder="Workout Name"
          required
        ></b-form-input>

        <label class="sr-only" for="input-duration">Duration</label>
        <b-form-input
          id="input-duration"
          v-model="form.duration"
          placeholder="Duration"
          required
        ></b-form-input>

        <label class="sr-only" for="input-satisfaction">Satisfaction</label>
        <b-form-input
          id="input-satisfaction"
          v-model="form.satisfaction"
          placeholder="Satisfaction"
          required
        ></b-form-input>

        
        <br />
        <b-button type="button" @click="onSave" variant="primary">Save</b-button>
        <b-button type="reset" variant="warning">Reset</b-button>
        <b-button type="button" @click="onDelete" variant="danger">Remove Exercise</b-button>
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
      exercise: null,
      query: '',
      fields: [
      {key: 'userExerciseKey.clientId', label: 'Client ID', sortable: true},
      {key: 'userExerciseKey.workoutId', label: 'Workout ID', sortable: true},
      {key: 'userExerciseKey.dayYear', label: 'Date', sortable: true},
      {key: 'workoutName', label: 'Workout Name', sortable: true},
      {key: 'duration', label: 'Duration', sortable: true},
      {key: 'satisfaction', label: 'Satisfaction', sortable: true},
      {key: 'actions', label: 'Actions'}],
      form: {
          clientId: '',
          workoutId: '',
          dayYear: '',
          workoutName: '',
          duration: '',
          satisfaction: ''
        },
    }
  },
  mounted () {
    this.init();
  },
  methods: {
    init() {
      axios
        .get('http://localhost:8085/exercise')
        .then(response => (this.exercise = response.data))
    },
    search(seachTerm){
      if (seachTerm){
        axios
        .get('http://localhost:8085/exercise/search/'+seachTerm)
        .then(response => (this.exercise = response.data))
        .catch(function(error){
          if (error.response){
            console.log(error.response.data);
          }
        })
      }
      console.log(seachTerm)
    },
    edit(item, index, button) {
      this.form.clientId = item.userExerciseKey.clientId
      this.form.workoutId = item.userExerciseKey.workoutId
      this.form.dayYear = item.userExerciseKey.dayYear
      this.form.workoutName = item.workoutName
      this.form.duration = item.duration
      this.form.satisfaction = item.satisfaction
      
    },
    resetEditModal() {
      this.form.clientId =''
      this.form.workoutId=''
      this.form.dayYear=''
      this.form.workoutName =''
      this.form.duration =''
      this.form.satisfaction =''
    },
    onSave(event) {
      var exercise;
      var date;
      var client;
      date = (this.form.dayYear)
      exercise = (this.form.workoutId)
      client = parseInt(this.form.clientId)
      axios
        .put('http://localhost:8085/exercise/' + client +'/' + exercise + '/' + date, {
          "workoutName": this.form.workoutName,
          "duration": this.form.duration,
          "satisfaction": this.form.satisfaction,
        })
        .then(() => this.init())
        .catch(function (error) {
          console.log(error);
        });
    },
    onDelete(event) {
      var exercise;
      var date;
      var client;
      date = (this.form.dayYear)
      exercise = (this.form.workoutId)
      client = parseInt(this.form.clientId)
        axios
          .delete('http://localhost:8085/exercise/'  + client +'/' + exercise + '/' + date)
          .then(() => this.init())
          .catch(function (error) {
            console.log(error);
          })
    },
    onAdd(event) {
      axios
        .post('http://localhost:8085/exercise', {
          "userExerciseKey": {
            "clientId": this.form.clientId,
            "workoutId": this.form.workoutId,
            "dayYear": this.form.dayYear
          },
          "workoutName": this.form.workoutName,
          "duration": this.form.duration,
          "satisfaction": this.form.satisfaction,
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
