import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import CartView from "@/views/CartView.vue";
import OrderView from "@/views/OrderView.vue";
import AboutUs from "@/views/AboutUs.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path:'/cart',
      name: 'cart',
      component: CartView
    },
    {
      path:'/order/:orderId',
      name: 'order',
      component: OrderView
    },
    {
      path:'/about',
      name: 'about',
      component: AboutUs
    }
  ]
})

export default router
