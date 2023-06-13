import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
// 引入store
import store from "./store/index";
// 关闭生产提示
createApp().config.productionTip = false;
createApp(store)
createApp(App).mount('#app')
