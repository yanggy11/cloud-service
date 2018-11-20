/**
 * @Author derrick.yang
 * @Date 28/10/2018
 */

let bookSqlMap = {
    add: 'insert into books(book_name, author_id) values(?,?);',
    queryBooks: 'select id, book_name as bookName, author_id as authorId from books;'
};

module.exports = bookSqlMap;
