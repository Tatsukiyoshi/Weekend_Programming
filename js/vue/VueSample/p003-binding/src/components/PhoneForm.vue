<template>
  <div class="comp-body">
    名前
    <div>
      <input type="text" :value="modelValue" @input="onUpdateModelValue">
    </div>
    メーカー
    <div>
      <input type="text" :value="vendor" @input="onUpdateVendor">
    </div>
    価格（円）
    <div>
      <input type="number" :value="price" @input="onUpdatePrice">
    </div>
  </div>
</template>
<script lang="ts">
import { defineComponent } from 'vue'
export default defineComponent({
  props: {
    modelValue: String, // v-modelで指定した名前
    vendor: String,   // v-model:vendorで指定したメーカー
    price: Number   // v-model:priceで指定した価格
  },
  emits: [
    'update:modelValue',
    'update:vendor',
    'update:price'
  ],
  setup(props, context) {
    const onUpdateModelValue = ((e: Event) => {
      if (e.target instanceof HTMLInputElement) {
        context.emit('update:modelValue', e.target.value)
      }
    })
    const onUpdateVendor = ((e: Event) => {
      if (e.target instanceof HTMLInputElement) {
        context.emit('update:vendor', e.target.value)
      }
    })
    const onUpdatePrice = ((e: Event) => {
      if (e.target instanceof HTMLInputElement) {
        context.emit('update:price', e.target.value)
      }
    })
    return {
      onUpdateModelValue,
      onUpdateVendor,
      onUpdatePrice
    }
  }
})
</script>
<style scoped>
.comp-body {
  padding: 10px;
  background-color: lightpink;
}
</style>