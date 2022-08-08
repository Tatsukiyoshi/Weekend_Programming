// Webページの動作を実装 ...（1）
const MyFirstVue = {
    data() { // データ ...（2）
      return {
        name: '吉川英一'
      }
    },
    methods: { // メソッド ...（3）
      onButtonClicked() {
      alert(`${this.name} さん、Vue.jsの世界にようこそ!`)
      }
    }
}
// Vue.jsを初期化 ...（4）
Vue.createApp(MyFirstVue).mount('#my-first-vue')
