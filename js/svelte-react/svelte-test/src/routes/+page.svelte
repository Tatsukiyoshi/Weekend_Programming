<script>
	import Button from './Button.svelte'
	import Heading from './Heading.svelte'
	let count = 0;
	let color = '#000000';

	const colors = ['#00ff00', '#ff0000', '#0000ff'];

	let handleClick = () => {
		count++;
		color = colors[Math.floor(Math.random() * 3)];
	}
</script>

<h1>Welcome to SvelteKit 5.25.2</h1>
<p>Visit <a href="https://svelte.dev/docs/kit">svelte.dev/docs/kit</a> to read the documentation</p>

<main>
	<Heading count={count} />
	<Button color={color} handleClick={handleClick} />
</main>
