<template>
    <div class="hello">
    <img alt="Users" src="https://i.ibb.co/kxCMg28/users-banner.png" height="50">
    <p></p>

      <b-button class="add-button" v-b-modal.add-modal>
        <b-icon-plus-circle></b-icon-plus-circle>
      </b-button>
      <p></p>
      <b-modal id="add-modal" ref="add-modal" title="Add User" @hide="resetEditModal" hide-footer>
      <b-form>
  
          <label class="sr-only" for="input-clientId">Client ID</label>
          <b-form-input
            id='input-clientId'
            v-model="form.clientId"
            placeholder="Client ID"
            required
          ></b-form-input>
  
          <label class="sr-only" for="input-firstName">First Name</label>
          <b-form-input
            id='input-firstName'
            v-model="form.firstName"
            placeholder="First Name"
            required
          ></b-form-input>
  
          <label class="sr-only" for="input-lastName">Last Name</label>
          <b-form-input
            id="input-lastName"
            v-model="form.lastName"
            placeholder="Last Name"
            required
          ></b-form-input>

          <label class="sr-only" for="input-age">Age</label>
          <b-form-input
            id="input-age"
            v-model="form.age"
            placeholder="Age"
            required
          ></b-form-input>

          <label class="sr-only" for="input-height">Height</label>
          <b-form-input
            id="input-height"
            v-model="form.height"
            placeholder="Height"
            required
          ></b-form-input>

          <label class="sr-only" for="input-weight">Weight</label>
          <b-form-input
            id="input-weight"
            v-model="form.weight"
            placeholder="Weight"
            required
          ></b-form-input>
          
          <label class="sr-only" for="input-password">Password</label>
          <b-form-input
            id="input-password"
            v-model="form.password"
            placeholder="Password"
            required
          ></b-form-input>
          
          <br />
          <b-button type="button" @click="onAdd" variant="primary">Add</b-button>
        </b-form>
      </b-modal>

    <div class="search-container">
      <b-input-group>
        <b-form-input type="text" placeholder="Search User's Name" v-model="query"/>
        <template #append>
          <b-button class="search-button" @click="search(query)">
            <b-icon-search></b-icon-search>
          </b-button>
        </template>
      </b-input-group>
    </div>

      <b-table striped hover responsive :items="user" :fields="fields">
        <template #cell(actions)="row">
          <b-button size="sm" v-b-modal.edit-modal @click="edit(row.item, row.index, $event.target)">
            Edit
          </b-button>
        </template>
      </b-table>
      <b-modal id="edit-modal" title="Edit Users" @hide="resetEditModal" hide-footer>
        <b-form>
  
          <label class="sr-only" for="input-clientId">Client ID</label>
          <b-form-input
            id='input-clientId'
            v-model="form.clientId"
            placeholder="Client ID"
            readonly
          ></b-form-input>
  
          <label class="sr-only" for="input-firstName">First Name</label>
          <b-form-input
            id='input-firstName'
            v-model="form.firstName"
            placeholder="First Name"
            required
          ></b-form-input>
  
          <label class="sr-only" for="input-lastName">Last Name</label>
          <b-form-input
            id="input-lastName"
            v-model="form.lastName"
            placeholder="Last Name"
            required
          ></b-form-input>

          <label class="sr-only" for="input-age">Age</label>
          <b-form-input
            id="input-age"
            v-model="form.age"
            placeholder="Age"
            required
          ></b-form-input>

          <label class="sr-only" for="input-height">Height</label>
          <b-form-input
            id="input-height"
            v-model="form.height"
            placeholder="Height"
            required
          ></b-form-input>

          <label class="sr-only" for="input-weight">Weight</label>
          <b-form-input
            id="input-weight"
            v-model="form.weight"
            placeholder="Weight"
            required
          ></b-form-input>
          
          <label class="sr-only" for="input-password">Password</label>
          <b-form-input
            id="input-password"
            v-model="form.password"
            placeholder="Password"
            required
          ></b-form-input>
          
          <br />
          <b-button type="button" @click="onSave" variant="primary">Save</b-button>
          <b-button type="reset" variant="warning">Reset</b-button>
          <b-button type="button" @click="onDelete" variant="danger">Remove User</b-button>
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
        user: null,
        query:'',
        fields: [
        {key: 'clientId', label: 'Client ID', sortable: true},
        {key: 'lastName', label: 'Last Name', sortable: true},
        {key: 'firstName', label: 'First Name', sortable: true},
        {key: 'age', label: 'Age', sortable: true},
        {key: 'height', label: 'Height', sortable: true},
        {key: 'weight', label: 'Weight', sortable: true},
        {key: 'password', label: 'Password', sortable: true},
        {key: 'actions', label: 'Actions'}],
        form: {
            clientId: '',
            firstName: '',
            lastName: '',
            age: '',
            height:'',
            weight:'',
            password:''
          },
      }
    },
    mounted () {
      this.init();
    },
    methods: {
      init() {
        axios
          .get('http://localhost:8085/user')
          .then(response => (this.user = response.data))
      },
      search(seachTerm){
        if (seachTerm){
          axios
          .get('http://localhost:8085/user/search/'+seachTerm)
          .then(response => (this.user = response.data))
          .catch(function(error){
            if (error.response){
              console.log(error.response.data);
            }
          })
        }
        console.log(seachTerm)
      },
      edit(item, index, button) {
        this.form.clientId = item.clientId
        this.form.firstName = item.firstName
        this.form.lastName = item.lastName
        this.form.age = item.age
        this.form.height = item.height
        this.form.weight = item.weight
        this.form.password = item.password
      },
      resetEditModal() {
        this.form.clientId=''
        this.form.firstName=''
        this.form.lastName=''
        this.form.age=''
        this.form.height=''
        this.form.weight=''
        this.form.password=''
      },
      onSave(event) {
        var client;
        client = parseInt(this.form.clientId);
        axios
          .put('http://localhost:8085/user/' + client, {
            "firstName": this.form.firstName,
            "lastName": this.form.lastName,
            "age": this.form.age,
            "height": this.form.height,
            "weight": this.form.weight,
            "password": this.form.password,
          })
          .then(() => this.init())
          .catch(function (error) {
            console.log(error);
          });
      },
      onDelete(event) {
        var client;
        client = parseInt(this.form.clientId);
        axios
          .delete('http://localhost:8085/user/' + client)
          .then(() => this.init())
          .catch(function (error) {
            console.log(error);
          })
      },
      onAdd(event) {
        axios
          .post('http://localhost:8085/user', {
            "clientId": this.form.clientId,
            "firstName": this.form.firstName,
            "lastName": this.form.lastName,
            "age": this.form.age,
            "height": this.form.height,
            "weight": this.form.weight,
            "password": this.form.password,
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
  