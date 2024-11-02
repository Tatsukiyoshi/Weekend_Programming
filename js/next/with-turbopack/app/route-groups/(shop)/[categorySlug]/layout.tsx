import { use } from 'react';
import { fetchCategoryBySlug, PageProps } from '@/lib/getCategories';
import ClickCounter from '@/ui/ClickCounter';
import SubCategoryNav from './SubCategoryNav';

export default function Layout(props: PageProps) {
  const params = use(props.params);

  const {
    children
  } = props;

  const category = use(fetchCategoryBySlug(params.categorySlug));
  if (!category) return null;

  return (
    <div className="space-y-9">
      <div className="flex items-center justify-between">
        <SubCategoryNav category={category} />
        <ClickCounter />
      </div>
      <div>{children}</div>
    </div>
  );
}
