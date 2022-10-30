import { BookService } from './book.service';

describe('BookServiceのテスト', () => {
  let service: BookService;

  beforeEach(() => {
    service = new BookService();
  });

  it('getBooksメソッドの動作', () => {
    let books = service.getBooks();

    // 取得したデータ件数を検証
    expect(books.length).toEqual(5);

    // １件目の署名を検証
    expect(books[0].title).toEqual('改訂新版JavaScript本格入門');
  });
});
