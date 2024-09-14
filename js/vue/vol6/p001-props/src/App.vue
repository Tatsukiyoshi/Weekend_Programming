<template>
  <div>
    <!-- Phone1コンポーネントの描画 ...（1）-->
    <Phone1 name="Galaxy S22" vendor="Samsung" :price="125030"></Phone1>
    <Phone1 name="AQUOS sense6" vendor="SHARP" :price="57024"></Phone1>
    <!-- Phone2コンポーネントの描画 ...（2）-->
    <div v-for="phone in phoneDataArray" v-bind:key="phone.name">
      <Phone2 :phoneData="phone"></Phone2>
    </div>
  </div>
</template>
<script lang="ts">
import { defineComponent } from 'vue'
// 子コンポーネントをインポート ...（3）
import Phone1 from './components/Phone1.vue'
import Phone2 from './components/Phone2.vue'
// PhoneDataクラスをインポート ...（4）
import PhoneData from './PhoneData'
export default defineComponent({
  // 使用するコンポーネントを指定 ...（5）
  components: {
    Phone1,
    Phone2
  },
  // Composition APIでAppコンポーネントを初期設定
  setup() {
    const phoneDataArray = [ // phoneDataArrayの初期化 ...（6）
      new PhoneData('Xperia 1 IV', 'Sony', 192930),
      new PhoneData('arrows We', 'FCNT', 22000)
    ]
    return { phoneDataArray }
  }
})
</script>
