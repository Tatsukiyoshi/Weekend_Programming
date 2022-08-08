<template>
  <div class="flex">
    <div class="flex-elem">
      <h3>親コンポーネント</h3>
      名前
      <div>
        <input type="text" v-model="paramName">
      </div>
      メーカー
      <div>
        <input type="text" v-model="paramVendor">
      </div>
      価格（円）
      <div>
        <input type="number" v-model="paramPrice">
      </div>
    </div>
    <div class="flex-elem">
      <h3>子コンポーネント</h3>
      <PhoneForm v-model="paramName" v-model:vendor="paramVendor"
        v-model:price="paramPrice"></PhoneForm>
    </div>
  </div>
</template>
<script lang="ts">
import { defineComponent, ref } from 'vue'
import PhoneForm from './components/PhoneForm.vue'
export default defineComponent({
  components: {
    PhoneForm
  },
  setup() {
    const paramName = ref('Galaxy S22')
    const paramVendor = ref('Samsung')
    const paramPrice = ref(125030)
    return {
      paramName, paramVendor, paramPrice
    }
  }
})
</script>
<style scoped>
.flex {
  display: flex;
}

.flex-elem {
  margin: 10px;
}
</style>