<template>
    <div class="login-container">
      <form @submit.prevent="login">
        <h2 class="mb-3">Login</h2>
        <div class="input">
          <label for="id">Client Id</label>
          <input
            class="form-control"
            type="text"
            name="id"
            placeholder="clientId"
            required
          />
        </div>
        <div class="input">
          <label for="password">Password</label>
          <input
            class="form-control"
            type="password"
            name="password"
            placeholder="password"
          />
        </div>
        <div class="alternative-option mt-4">
          You don't have an account? <span @click="moveToRegister">Register</span>
        </div>
        <button type="submit" class="mt-4 btn-pers" id="login_button">
          Login
        </button>
        <div
          class="alert alert-danger fade show mt-5 d-none"
          role="alert"
          id="alert_1"
        >
          Lorem ipsum dolor sit amet consectetur, adipisicing elit.
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="alert"
            aria-label="Close"
          ></button>
        </div>
      </form>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  export default {
    name: 'Login',
    data() {
      return {
        id: "",
        password: "",
      };
    },
    methods: {
      login(submitEvent) {
        this.id = submitEvent.target.elements.id.value;
        this.password = submitEvent.target.elements.password.value;
        axios.all([
            axios.get('http://localhost:8085/user/'+this.id)
            .catch(
                function(e){console.log('Error', e);})
            ])
            .then(axios.spread((data1) => {
            console.log('data1', data1)
            if (typeof data1 !== 'undefined'){
                this.$root.$emit("authenticated", true);
                this.$root.$emit("authorized", false);
                this.$root.$emit('User',data1.data);
                this.$router.push("/");
            }
            else{
                let alert_1 = document.querySelector("#alert_1");
                alert_1.classList.remove("d-none");
                alert_1.innerHTML = 'User Does Not Exist!';
            }
        }));

      },
      moveToRegister() {
        this.$router.push("/register");
      },
    },
  };
  </script>

<style scoped>
.login-container{
    max-width: 70%;
    margin: auto;
}
</style>