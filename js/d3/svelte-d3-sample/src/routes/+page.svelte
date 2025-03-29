<script lang="ts">
    import { onMount } from 'svelte';
    import LinePlot from './LinePlot.svelte';
    
    let data = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
    
    onMount(() => {
        console.log('Component mounted');
        // You can add any additional logic here
    });
</script>

<LinePlot {data}></LinePlot>
