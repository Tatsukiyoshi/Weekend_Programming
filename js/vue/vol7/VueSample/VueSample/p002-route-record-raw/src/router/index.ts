import { createRouter, createWebHistory, type RouteRecordRaw } from 'vue-router'
import SingleView from '../views/SingleView.vue'
import SingleViewWithChildren from '../views/SingleViewWithChildren.vue'
import MultipleView from '../views/MultipleView.vue'
import MultipleViewWithChildren from '../views/MultipleViewWithChildren.vue'
import HeaderView from '../views/HeaderView.vue'
import FooterView from '../views/FooterView.vue'
import ChildView1 from '../views/ChildView1.vue'
import ChildView2 from '../views/ChildView2.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  // routesは、RouteRecordRaw型の配列になる
  routes: [
    // RouteRecordSingleView：1つのパスに1つのコンポーネント
    {
      path: '/single',
      component: SingleView
    },
    // RouteRecordSingleViewWithChildren：1つのパスに1つのコンポーネントとn個の子要素
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
    // RouteRecordMultipleViews：1つのパスにn個のコンポーネント
    {
      path: '/multiple',
      components: {
        default: MultipleView,
        Header: HeaderView,
        Footer: FooterView
      }
    },
    // RouteRecordMultipleViewsWithChildren：1つのパスにn個のコンポーネントとm個の子要素
    {
      path: '/multiple-with-children',
      components: {
        default: MultipleViewWithChildren,
        Header: HeaderView,
        Footer: FooterView
      },
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
    // RouteRecordRedirect：1つのパスに別のパスへのリダイレクト
    {
      path: '/',
      redirect: '/single'
    }
  ]
})
export default router
