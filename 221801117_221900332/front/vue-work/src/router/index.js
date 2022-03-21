import { createRouter, createWebHistory } from 'vue-router'


const routes = [
  {
    path: '/home',
    name: 'Home',
    component: ()=>import('../views/Home'),
    children: [
      {
        path:'/home/mainPage',
        name:'mainPage',
        component: ()=>import('../components/Common/Nav'),
        children:[
          {
            path:'/home/mainPage/index',
            name:'index',
            component: ()=>import('../views/Index'),
          },
          {
            path:'/home/mainPage/worldMap',
            name:'worldMap',
            component: ()=>import('../views/WorldMap'),
          },
          {
            path:'/home/mainPage/Schedule',
            name:'schedule',
            component: ()=>import('../views/Schedule'),
          }
        ]
      }
    ]
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../components/Common/World')
  },
  {
    path: '/test',
    name: 'test',
    component: ()=>import('../views/Home'),
    children:[
      {
        path:'/test/test'
      }
    ]

  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
