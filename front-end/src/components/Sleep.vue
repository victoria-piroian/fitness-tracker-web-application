<template>
  <div class="hello">
    <img alt="Sleep" src="https://i.ibb.co/cLWtw38/sleep-banner.png" height="50">
    <p></p>

    <b-button class="add-button" v-b-modal.add-modal>
        <b-icon-plus-circle></b-icon-plus-circle>
      </b-button>
    <p></p>
      <b-modal id="add-modal" ref="add-modal" title="Add Sleep" @hide="resetEditModal" hide-footer>
      <b-form>

        <label class="sr-only" for="input-ClientId">Client ID</label>
        <b-form-input
          id='input-clientId'
          v-model="form.clientId"
          placeholder="Client Id"
          required
        ></b-form-input>

        <label class="sr-only" for="input-dayYear">Date</label>
        <b-form-input
          id='input-dayYear'
          v-model="form.dayYear"
          placeholder="Date"
          required
        ></b-form-input>

        <label class="sr-only" for="input-duration">Duration</label>
        <b-form-input
          id='input-duration'
          v-model="form.duration"
          placeholder="Duration"
          required
        ></b-form-input>

        <label class="sr-only" for="input-restScore">Rest Score</label>
        <b-form-input
          id="input-restScore"
          v-model="form.restScore"
          placeholder="Rest Score"
          required
        ></b-form-input>

        <label class="sr-only" for="input-dream">Dream</label>
        <b-form-input
          id="input-dream"
          v-model="form.dream"
          placeholder="Dream"
          required
        ></b-form-input>

        <label class="sr-only" for="input-alarmWakeUp">Alarm Wake Up</label>
        <b-form-input
          id="input-alarmWakeUp"
          v-model="form.alarmWakeUp"
          placeholder="Alarm Wake Up"
          required
        ></b-form-input>

        <label class="sr-only" for="input-numNaps">Number of Naps</label>
        <b-form-input
          id="input-numNaps"
          v-model="form.numNaps"
          placeholder="Number of Naps"
          required
        ></b-form-input>

        <br />
          <b-button type="button" @click="onAdd" variant="primary">Add</b-button>
        </b-form>
      </b-modal>

    <div class="search-container">
      <b-input-group>
        <b-form-input type="text" placeholder="Search Sleep Date" v-model="query"/>
        <template #append>
          <b-button class="search-button" @click="search(query)">
            <b-icon-search></b-icon-search>
          </b-button>
        </template>
      </b-input-group>
    </div>


    <b-table striped hover responsive :items="sleep" :fields="fields">
      <template #cell(actions)="row">
        <b-button size="sm" v-b-modal.edit-modal @click="edit(row.item, row.index, $event.target)">
          Edit
        </b-button>
      </template>
    </b-table>
    <b-modal id="edit-modal" title="Edit Sleep" @hide="resetEditModal" hide-footer>
      <b-form>

        <label class="sr-only" for="input-ClientId">Client ID</label>
        <b-form-input
          id='input-clientId'
          v-model="form.clientId"
          placeholder="Client Id"
          readonly
        ></b-form-input>

        <label class="sr-only" for="input-dayYear">Date</label>
        <b-form-input
          id='input-dayYear'
          v-model="form.dayYear"
          placeholder="Date"
          readonly
        ></b-form-input>

        <label class="sr-only" for="input-duration">Duration</label>
        <b-form-input
          id='input-duration'
          v-model="form.duration"
          placeholder="Duration"
          required
        ></b-form-input>

        <label class="sr-only" for="input-restScore">Rest Score</label>
        <b-form-input
          id="input-restScore"
          v-model="form.restScore"
          placeholder="Rest Score"
          required
        ></b-form-input>

        <label class="sr-only" for="input-dream">Dream</label>
        <b-form-input
          id="input-dream"
          v-model="form.dream"
          placeholder="Dream"
          required
        ></b-form-input>

        <label class="sr-only" for="input-alarmWakeUp">Alarm Wake Up</label>
        <b-form-input
          id="input-alarmWakeUp"
          v-model="form.alarmWakeUp"
          placeholder="Alarm Wake Up"
          required
        ></b-form-input>

        <label class="sr-only" for="input-numNaps">Number of Naps</label>
        <b-form-input
          id="input-numNaps"
          v-model="form.numNaps"
          placeholder="Number of Naps"
          required
        ></b-form-input>

        <br />
        <b-button type="button" @click="onSave" variant="primary">Save</b-button>
        <b-button type="reset" variant="warning">Reset</b-button>
        <b-button type="button" @click="onDelete" variant="danger">Remove Sleep</b-button>
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
      sleep: null,
      query: '',
      fields: [
      {key: 'userSleepKey.clientId', label: 'Client ID', sortable: true},
      {key: 'userSleepKey.dayYear', label: 'Date', sortable: true},
      {key: 'duration', label: 'Duration', sortable: true},
      {key: 'restScore', label: 'Rest Score', sortable: true},
      {key: 'dream', label: 'Dream', sortable: true},
      {key: 'alarmWakeUp', label: 'Alarm Wake Up', sortable: true},
      {key: 'numNaps', label: 'Number of Naps', sortable: true},
      {key: 'actions', label: 'Actions'}],
      form: {
          clientId: '',
          dayYear: '',
          duration: '',
          restScore: '',
          dream: '',
          alarmWakeUp:'',
          numNaps:''
        },
    }
  },
  mounted () {
    this.init();
  },
  methods: {
    init() {
      axios
        .get('http://localhost:8085/sleep')
        .then(response => (this.sleep = response.data))
    },
    search(seachTerm){
      if (seachTerm){
        axios
        .get('http://localhost:8085/sleep/search/'+seachTerm)
        .then(response => (this.sleep = response.data))
        .catch(function(error){
          if (error.response){
            console.log(error.response.data);
          }
        })
      }
      console.log(seachTerm)
    },    
    edit(item, index, button) {
      this.form.clientId = item.userSleepKey.clientId
      this.form.dayYear = item.userSleepKey.dayYear
      this.form.duration = item.duration
      this.form.restScore = item.restScore
      this.form.dream = item.dream
      this.form.alarmWakeUp = item.alarmWakeUp
      this.form.numNaps = item.numNaps      
    },
    resetEditModal() {
      this.form.clientId =''
      this.form.dayYear=''
      this.form.duration=''
      this.form.restScore=''
      this.form.dream=''
      this.form.alarmWakeUp=''
      this.form.numNaps=''
    },
    onSave(event) {
      var date;
      var client;
      date = (this.form.dayYear);
      client = parseInt(this.form.clientId);
      axios
        .put('http://localhost:8085/sleep/' + client +'/' + date, {
          "duration": this.form.duration,
          "restScore": this.form.restScore,
          "dream": this.form.dream,
          "alarmWakeUp": this.form.alarmWakeUp,
          "numNaps": this.form.numNaps,
        })
        .then(() => this.init())
        .catch(function (error) {
          console.log(error);
        });
    },
    onDelete(event) {
      var date;
      var client;
      date = (this.form.dayYear)
      client = parseInt(this.form.clientId)
        axios
          .delete('http://localhost:8085/sleep/'  + client + '/' + date)
          .then(() => this.init())
          .catch(function (error) {
            console.log(error);
          })
    },
    onAdd(event) {
      axios
        .post('http://localhost:8085/sleep', {
          "userSleepKey": {
            "clientId": this.form.clientId,
            "dayYear": this.form.dayYear
          },
          "duration": this.form.duration,
          "restScore": this.form.restScore,
          "dream": this.form.dream,
          "alarmWakeUp": this.form.alarmWakeUp,
          "numNaps": this.form.numNaps,
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
