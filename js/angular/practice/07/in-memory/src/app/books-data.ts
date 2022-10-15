import { InMemoryDbService, RequestInfo } from "angular-in-memory-web-api";

export class BooksData implements InMemoryDbService {
    createDb() {
        let books = [
            {
                id: 1,
                isbn: '978-4-7741-8411-1',
                title: '改訂新版JavaScript本格入門',
                price: 2980
            },
            {
                id: 2,
                isbn: '978-4-7980-4853-6',
                title: 'はじめてのAndroidアプリ開発 第2版',
                price: 3200
            },
        ];
        return { books };
    }
}
