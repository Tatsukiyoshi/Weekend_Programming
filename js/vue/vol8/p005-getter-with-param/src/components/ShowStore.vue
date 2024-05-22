<template>
  <div class="component">
    <div>{{ store.name }}（{{ store.vendor }}、{{ store.formattedPriceWithUnit('￥') }}）</div>
    <div>機能：
      <span v-for="feature in store.features">{{ feature }}</span>
    </div>
  </div>
</template>
<script setup lang="ts">
// ストアを取得
import { usePhoneStore } from '../stores/phone'
const store = usePhoneStore()
</script>
<style scoped>
.component {
  background-color: lightblue;
  padding: 15px;
}
span:not(:last-child):after {
  content: "、";
}
</style>