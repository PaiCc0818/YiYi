import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
// 引入axios
import axios from 'axios'
axios.defaults.baseURL = 'http://localhost:8899'

createApp(App).use(store).use(router).mount('#app')
