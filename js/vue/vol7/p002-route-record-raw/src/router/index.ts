import { createRouter, createWebHistory } from 'vue-router'
import SingleViewWithChildren from '../views/SingleViewWithChildren.vue'
import ChildView1 from '../views/ChildView1.vue'
import ChildView2 from '../views/ChildView2.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/single-with-children',
      component: SingleViewWithChildren,
      children: [
        {
          path: 'child1',
          component: ChildView1
        },
        {
          path: 'child2',
          component: ChildView2
        }
      ]
    },
  ]
})

export default router
