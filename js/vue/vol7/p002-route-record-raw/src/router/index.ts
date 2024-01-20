import { createRouter, createWebHistory } from 'vue-router'
import SingleView from '../views/SingleView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/single',
      component: SingleView
    },
  ]
})

export default router
