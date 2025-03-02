import { fetchCategoryBySlug, PageProps } from '@/lib/getCategories';
import { Boundary } from '@/ui/Boundary';
import { use } from 'react';
import { Counter } from '../ClickCounter';

export default function Page(props: PageProps) {
  const params = use(props.params);
  const category = use(fetchCategoryBySlug(params.categorySlug));
  if (!category) return null;

  return (
    <Boundary labels={['Page [Server Component]']} animateRerendering={false}>
      <div className="space-y-8">
        <div className="text-xl font-medium text-zinc-500">
          All {category.name}
        </div>

        <Counter />
      </div>
    </Boundary>
  );
}
