<template>
  <div class="component">
    <div>機種：<input v-model="store.name"></div>
    <div>会社：<input v-model="store.vendor"></div>
    <div>価格：<input v-model.number="store.price"></div>
  </div>
</template>
<script setup lang="ts">
// ストアを取得
import { usePhoneStore } from '../stores/phone'
const store = usePhoneStore()
</script>
<style scoped>
.component {
  background-color: lightpink;
  padding: 15px;
}
</style>