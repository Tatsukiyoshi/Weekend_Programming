import { createRouter, createWebHistory } from 'vue-router'
import FruitView1 from '../views/FruitView1.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/fruit1/:name/:price/:count',
      component: FruitView1
    },
  ]
})

export default router
