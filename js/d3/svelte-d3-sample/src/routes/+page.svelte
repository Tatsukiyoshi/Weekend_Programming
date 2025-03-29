<script lang="ts">
    import { onMount } from 'svelte';
    import LinePlot from './LinePlot.svelte';
    
    let data = [1, 3, 2, 5, 4, 7, 6, 10, 8, 9];
    
    onMount(() => {
        console.log('Component mounted');
        // You can add any additional logic here
    });
</script>

<h1>Welcome to your library project</h1>
<p>Create your package using @sveltejs/package and preview/showcase your work with SvelteKit</p>
<p>Visit <a href="https://svelte.dev/docs/kit">svelte.dev/docs/kit</a> to read the documentation</p>

<LinePlot {data}></LinePlot>
