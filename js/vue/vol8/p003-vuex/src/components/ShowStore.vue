<template>
  <div class="component">
    <!-- ストアの内容を表示 -->
    <div>State（count）：{{ store.state.count }}</div>
    <div>Getter（doubleCount）：{{ store.getters.doubleCount }}</div>
  </div>
</template>
<script setup lang="ts">
// ストアを取得
import { useStore } from 'vuex'
const store = useStore()
</script>
<style scoped>
.component {
  background-color: lightblue;
  padding: 15px;
}
</style>