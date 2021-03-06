import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus'
import axios from 'axios'
import 'element-plus/dist/index.css'

let app = createApp(App)
app.config.globalProperties.$axios=axios;

app.use(store).use(router).use(ElementPlus).mount('#app')
