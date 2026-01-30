import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Users from '@/components/Users'
import Exercises from '@/components/Exercises'
import Diets from '@/components/Diets'
import Login from '@/components/Login'
import Progress from '@/components/Progress'
import Sleep from '@/components/Sleep'
import About from '@/components/About'
import Resources from '@/components/Resources'



Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/users',
      name: 'Users',
      component: Users
    },
    {
      path: '/exercises',
      name: 'Exercises',
      component: Exercises
    },    
    {
      path: '/diets',
      name: 'Diets',
      component: Diets
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/progress',
      name: 'Progress',
      component: Progress
    },
    {
      path: '/sleep',
      name: 'Sleep',
      component: Sleep
    },
    {
      path: '/about',
      name: 'About',
      component: About
    },
    {
      path: '/resources',
      name: 'Resources',
      component: Resources
    },
  ]
})
