<template>
  <div class="hello">
    <img alt="Diets" src="https://i.ibb.co/GcYTMxW/diet-banner.png" height="50">
    <p></p>

    <b-button class="add-button" v-b-modal.add-modal>
        <b-icon-plus-circle></b-icon-plus-circle>
      </b-button>
    <p></p>
      <b-modal id="add-modal" ref="add-modal" title="Add Meal" @hide="resetEditModal" hide-footer>
      <b-form>

        <label class="sr-only" for="input-clientId">Client ID</label>
        <b-form-input
          id='input-clientId'
          v-model="form.clientId"
          placeholder="Client ID"
          required
        ></b-form-input>

        <label class="sr-only" for="input-mealType">Meal Type</label>
        <b-form-input
          id='input-mealType'
          v-model="form.mealType"
          placeholder="Meal Type"
          required
        ></b-form-input>

        <label class="sr-only" for="input-dayYear">Date</label>
        <b-form-input
          id='input-dayYear'
          v-model="form.dayYear"
          placeholder="Date"
          required
        ></b-form-input>

        <label class="sr-only" for="input-mealName">Meal Name</label>
        <b-form-input
          id='input-mealName'
          v-model="form.mealName"
          placeholder="Meal Name"
          required
        ></b-form-input>

        <label class="sr-only" for="input-calories">Calories</label>
        <b-form-input
          id="input-calories"
          v-model="form.calories"
          placeholder="Calories"
          required
        ></b-form-input>

        <label class="sr-only" for="input-sugar">Sugar</label>
        <b-form-input
          id="input-sugar"
          v-model="form.sugar"
          placeholder="Sugar"
          required
        ></b-form-input>

        <label class="sr-only" for="input-carbs">Carbohydrates</label>
        <b-form-input
          id="input-carbs"
          v-model="form.carbs"
          placeholder="Carbohydrates"
          required
        ></b-form-input>

        <label class="sr-only" for="input-protein">Protein</label>
        <b-form-input
          id="input-protein"
          v-model="form.protein"
          placeholder="Protein"
          required
        ></b-form-input>

        <label class="sr-only" for="input-fat">Fat</label>
        <b-form-input
          id="input-fat"
          v-model="form.fat"
          placeholder="Fat"
          required
        ></b-form-input>
        
          <br />
          <b-button type="button" @click="onAdd" variant="primary">Add</b-button>
        </b-form>
      </b-modal>

    <div class="search-container">
      <b-input-group>
        <b-form-input type="text" placeholder="Search Meal Name" v-model="query"/>
        <template #append>
          <b-button class="search-button" @click="search(query)">
            <b-icon-search></b-icon-search>
          </b-button>
        </template>
      </b-input-group>
    </div>



  
    <b-table striped hover responsive :items="diet" :fields="fields">
      <template #cell(actions)="row">
        <b-button size="sm" v-b-modal.edit-modal @click="edit(row.item, row.index, $event.target)">
          Edit
        </b-button>
      </template>
    </b-table>
    <b-modal id="edit-modal" title="Edit Diets" @hide="resetEditModal" hide-footer>
      <b-form>

        <label class="sr-only" for="input-clientId">Client ID</label>
        <b-form-input
          id='input-clientId'
          v-model="form.clientId"
          placeholder="Client ID"
          readonly
        ></b-form-input>

        <label class="sr-only" for="input-mealType">Meal Type</label>
        <b-form-input
          id='input-mealType'
          v-model="form.mealType"
          placeholder="Meal Type"
          readonly
        ></b-form-input>

        <label class="sr-only" for="input-dayYear">Date</label>
        <b-form-input
          id='input-dayYear'
          v-model="form.dayYear"
          placeholder="Date"
          readonly
        ></b-form-input>

        <label class="sr-only" for="input-mealName">Meal Name</label>
        <b-form-input
          id='input-mealName'
          v-model="form.mealName"
          placeholder="Meal Name"
          required
        ></b-form-input>

        <label class="sr-only" for="input-calories">Calories</label>
        <b-form-input
          id="input-calories"
          v-model="form.calories"
          placeholder="Calories"
          required
        ></b-form-input>

        <label class="sr-only" for="input-sugar">Sugar</label>
        <b-form-input
          id="input-sugar"
          v-model="form.sugar"
          placeholder="Sugar"
          required
        ></b-form-input>

        <label class="sr-only" for="input-carbs">Carbohydrates</label>
        <b-form-input
          id="input-carbs"
          v-model="form.carbs"
          placeholder="Carbohydrates"
          required
        ></b-form-input>

        <label class="sr-only" for="input-protein">Protein</label>
        <b-form-input
          id="input-protein"
          v-model="form.protein"
          placeholder="Protein"
          required
        ></b-form-input>

        <label class="sr-only" for="input-fat">Fat</label>
        <b-form-input
          id="input-fat"
          v-model="form.fat"
          placeholder="Fat"
          required
        ></b-form-input>


        <br />
        <b-button type="button" @click="onSave" variant="primary">Save</b-button>
        <b-button type="reset" variant="warning">Reset</b-button>
        <b-button type="button" @click="onDelete" variant="danger">Remove Diet</b-button>
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
      diet: null,
      query: '',
      fields: [
      {key: 'userMealKey.clientId', label: 'Client ID', sortable: true},
      {key: 'userMealKey.mealType', label: 'Meal Type', sortable: true},
      {key: 'userMealKey.dayYear', label: 'Date', sortable: true},
      {key: 'mealName', label: 'Meal Name', sortable: true},
      {key: 'calories', label: 'Calories', sortable: true},
      {key: 'sugar', label: 'Sugar', sortable: true},
      {key: 'carbs', label: 'Carbohydrates', sortable: true},
      {key: 'protein', label: 'Protein', sortable: true},
      {key: 'fat', label: 'Fat', sortable: true},
      {key: 'actions', label: 'Actions'}],
      form: {
          clientId: '',
          mealType: '',
          dayYear: '',
          mealName: '',
          calories: '',
          sugar: '',
          carbs:'',
          protein:'',
          fat:''
        },
    }
  },
  mounted () {
    this.init();
  },
  methods: {
    init() {
      axios
        .get('http://localhost:8085/diet')
        .then(response => (this.diet = response.data))
    },
    search(seachTerm){
      if (seachTerm){
        axios
        .get('http://localhost:8085/diet/search/'+seachTerm)
        .then(response => (this.diet = response.data))
        .catch(function(error){
          if (error.response){
            console.log(error.response.data);
          }
        })
      }
      console.log(seachTerm)
    },
    edit(item, index, button) {
      this.form.clientId = item.userMealKey.clientId
      this.form.mealType = item.userMealKey.mealType
      this.form.dayYear = item.userMealKey.dayYear
      this.form.mealName = item.mealName
      this.form.calories = item.calories
      this.form.sugar = item.sugar
      this.form.carbs = item.carbs
      this.form.protein = item.protein
      this.form.fat = item.fat
      
    },
    resetEditModal() {
      this.form.clientId=''
      this.form.mealType=''
      this.form.dayYear=''
      this.form.mealName=''
      this.form.calories=''
      this.form.sugar=''
      this.form.carbs=''
      this.form.protein=''
      this.form.fat=''
    },
    onSave(event) {
      var meal;
      var date;
      var client;
      date = (this.form.dayYear);
      meal = (this.form.mealType);
      client = parseInt(this.form.clientId);
      axios
        .put('http://localhost:8085/diet/' + client +'/' + meal + '/' + date, {
          "mealName": this.form.mealName,
          "calories": this.form.calories,
          "sugar": this.form.sugar,
          "carbs": this.form.carbs,
          "protein": this.form.protein,
          "fat": this.form.fat,
        })
        .then(() => this.init())
        .catch(function (error) {
          console.log(error);
        });
    },
    onDelete(event) {
      var meal;
      var date;
      var client;
      date = (this.form.dayYear)
      meal = (this.form.mealType)
      client = parseInt(this.form.clientId)
        axios
          .delete('http://localhost:8085/diet/'  + client +'/' + meal + '/' + date)
          .then(() => this.init())
          .catch(function (error) {
            console.log(error);
          })
    },
    onAdd(event) {
      axios
        .post('http://localhost:8085/diet', {
          "userMealKey": {
            "clientId": this.form.clientId,
            "mealType": this.form.mealType,
            "dayYear": this.form.dayYear
          },
          "mealName": this.form.mealName,
          "calories": this.form.calories,
          "sugar": this.form.sugar,
          "carbs": this.form.carbs,
          "protein": this.form.protein,
          "fat": this.form.fat,
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

