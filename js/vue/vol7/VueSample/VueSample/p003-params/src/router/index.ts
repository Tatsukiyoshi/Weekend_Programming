import { createRouter, createWebHistory } from 'vue-router'
import FruitView1 from '../views/FruitView1.vue'
import FruitView2 from '../views/FruitView2.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/fruit1/:name/:price/:count',
      component: FruitView1
    },
    {
      path: '/fruit2/:name/:price/:count',
      component: FruitView2,
      props: true // propsによるパラメーター渡しを有効化
    }
  ]
})

export default router
