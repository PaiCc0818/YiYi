import {createRouter,createWebHistory} from 'vue-router'
import Home from "@/views/home/Home.vue";

// 路由数组
const routes = [
  // user组件作为前台展示组件
  {
    path: '/',
    name: 'Home',
    component: Home,
    redirect: '/index',
    children: [
      // 博客首页
      {
        path: '/index',
        name: 'AppIndex',
        component: () => import('../views/home/Index.vue'),
        meta: {title: '帅の博客'},
      },
    ]
  },
  // admin组件作为后台管理组件
  {
    path: '/admin',
    name: 'Admin',
    component: () => import('../views/admin/Admin.vue'),
    redirect: '/admin/commodity',
    children: [
      // 博客管理
      {
        path: '/admin/commodity',
        name: 'Commodity',
        component: () => import('../views/admin/Commodity.vue'),
      },
    ]
  },
  // check组件作为登录注册界面
  {
    path: '/check',
    name: 'Check',
    component: () => import('../views/login/Login.vue'),
    redirect: '/login',
    children: [
      {
        // 登录界面
        path: '/login',
        name: 'Login',
        component: () => import('../views/login/CheckLogin.vue'),
        meta: {title: '用户登录'},
      },
      {
        // 注册界面
        path: '/register',
        name: 'Register',
        component: () => import('../views/login/Register.vue'),
        meta: {title: '用户注册'},
      },
    ]
  },
];

// 创建一个路由
const router = createRouter({
  history: createWebHistory(),
  routes
})

// 全局后置路由 更新页面标题
router.afterEach((to)=>{
  document.title = to.meta.title;
});

// 暴露这个路由
export default router
