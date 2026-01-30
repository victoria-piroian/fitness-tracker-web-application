<template>
  <div id="app">
  <b-container>
    <div>
      <b-navbar toggleable type="light" variant="info">
      <b-navbar-brand href="#"><b-icon icon="flower1" variant="dark" style="margin-left: 20px;"></b-icon>
        <img alt="Vida Fit" src="https://i.ibb.co/zQkdkPp/vidaFit.png" height="18">
         </b-navbar-brand>

      <b-navbar-toggle target="sidebar-menu">
      </b-navbar-toggle>
      <b-sidebar id="sidebar-menu" title="Menu" backdrop-variant="dark" backdrop shadow>
        <b-nav vertical align="center">
          <b-nav-item to="/" exact exact-active-class="exact-active"><b-icon icon="house-door" variant="primary"></b-icon>  Home</b-nav-item>
          <b-nav-item to="/about" exact exact-active-class="exact-active"><b-icon icon="chat" variant="primary"></b-icon>  About</b-nav-item>
          <b-nav-item to="/users" exact exact-active-class="exact-active"><b-icon icon="person" variant="primary"></b-icon>  Users</b-nav-item>
          <b-nav-item to="/exercises" exact exact-active-class="exact-active"><b-icon icon="heart" variant="primary"></b-icon>  Exercises</b-nav-item>
          <b-nav-item to="/diets" exact exact-active-class="exact-active"><b-icon icon="cup-straw" variant="primary"></b-icon>  Diets</b-nav-item>
          <b-nav-item to="/progress" exact exact-active-class="exact-active"><b-icon icon="journal-check" variant="primary"></b-icon>  Progress</b-nav-item>
          <b-nav-item to="/sleep" exact exact-active-class="exact-active"><b-icon icon="moon-stars" variant="primary"></b-icon>  Sleep</b-nav-item>
          <b-nav-item to="/resources" exact exact-active-class="exact-active"><b-icon icon="info-circle" variant="primary"></b-icon>  Resources</b-nav-item>
          <b-nav-item disabled>Admin</b-nav-item>
        </b-nav>
      </b-sidebar>
    </b-navbar>
    </div>
    <br />
    <router-view/>
    </b-container>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
#app {
  font-family: 'Avenir', sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #000000;
  margin-top: 20px;
}
</style>
