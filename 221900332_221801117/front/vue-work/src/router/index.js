import { createRouter, createWebHistory } from 'vue-router'


const routes = [
  {
    path: '/home',
    name: 'Home',
    component: ()=>import('../views/Home'),
    children: [
      {
        path:'/home',
        redirect:'/home/mainPage'
      },
      {
        path:'/home/mainPage',
        name:'mainPage',
        component: ()=>import('../components/Common/Nav'),
        children:[
          {
            path:'/home/mainPage',
            redirect:'/home/mainPage/index'
          },
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
            path:'/home/mainPage/Rank',
            name:'rank',
            component: ()=>import('../views/Rank'),
          },
          {
            path:'/home/mainPage/schedule',
            name:'schedule',
            component: ()=>import('../views/Schedule'),
          }
        ]
      },
      {
        path:'/home/detail',
        name:'detail',
        component:()=>import('../views/Detail/DetialIndex'),
        children:[
          {
            path:'/home/detail/iceBall',
            name:'iceBall',
            component:()=>import('../views/Detail/IceBall')
          },
          {
            path:'/home/detail/icePot',
            name:'icePot',
            component:()=>import('../views/Detail/IcePot')
          },
          {
            path:'/home/detail/Ski',
            name:'ski',
            component:()=>import('../views/Detail/Ski')
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
