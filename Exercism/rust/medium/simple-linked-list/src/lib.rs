use std::fmt::{Debug, Display};

/// Node構造体（from HINTS.md）
#[derive(Debug)]
struct Node<T> {
    data: T,
    next: Option<Box<Node<T>>>,
}

impl<T: Clone> Node<T> {
    pub fn new(_data: T) -> Self {
        Node { data: _data, next: None }
    }
}

#[derive(Debug)]
pub struct SimpleLinkedList<T> {
    head: Option<Box<Node<T>>>,
    size: usize
}

impl<T: Clone + Debug + Display> SimpleLinkedList<T> {
    pub fn new() -> Self {
        SimpleLinkedList { head: None, size: 0 }
    }

    // You may be wondering why it's necessary to have is_empty()
    // when it can easily be determined from len().
    // It's good custom to have both because len() can be expensive for some types,
    // whereas is_empty() is almost always cheap.
    // (Also ask yourself whether len() is expensive for SimpleLinkedList)
    pub fn is_empty(&self) -> bool {
        self.size == 0
    }

    /// 長さの取得
    /// Emptyの場合、０
    /// Emptyでなければ、headから順にNodeをたどる（head -> next -> next ...）
    pub fn len(&self) -> usize {
        self.size
    }

    /// 末端への Node の追加
    /// - 入力
    ///   - 追加要素
    /// - Reference
    ///   - [Code on Stackoverflow](https://stackoverflow.com/questions/37643310/error-cannot-move-out-of-borrowed-content-for-self-field)
    pub fn push(&mut self, _element: T) {
        let node = &mut self.head;
        if node.is_none() {
            let new_node = Node::new(_element);
            //println!("first node = {:?}", new_node);
            self.head = Option::from(Box::new(new_node));
            self.size += 1;
        } else {
            let mut last_node = node.as_mut().unwrap();
            loop {
                if last_node.next.is_none() {
                    let new_node = Node::new(_element.clone());
                    //let next = std::mem::replace(last_node, Box::new(new_node));
                    let next = Box::new(new_node);
                    last_node.next = Option::from(next);
                    self.size += 1;
                    break;
                } else {
                    last_node = last_node.next.as_mut().unwrap();
                }
            }
        }
    }

    /// 末端 Node の取得
    pub fn pop(&mut self) -> Option<T> {
        todo!()
        /*
        let data: Option<T>;
        let mut node = &mut self.head;
        let mut work_node = node.as_mut().unwrap().next;
        if node.is_none() {
            None
        } else {
            loop {
                work_node = node.as_mut().unwrap().next;
                if work_node.unwrap().next.is_none() {
                    data = Option::from(work_node.unwrap().data.clone());
                    self.size -= 1;
                    break;
                }
                node = &mut work_node.unwrap().next;
            }
            data
        }
        */
    }

    pub fn peek(&self) -> Option<&T> {
        todo!()
    }

    #[must_use]
    pub fn rev(self) -> SimpleLinkedList<T> {
        todo!()
    }
}

impl<T> FromIterator<T> for SimpleLinkedList<T> {
    fn from_iter<I: IntoIterator<Item = T>>(_iter: I) -> Self {
        todo!()
    }
}

// In general, it would be preferable to implement IntoIterator for SimpleLinkedList<T>
// instead of implementing an explicit conversion to a vector. This is because, together,
// FromIterator and IntoIterator enable conversion between arbitrary collections.
// Given that implementation, converting to a vector is trivial:
//
// let vec: Vec<_> = simple_linked_list.into_iter().collect();
//
// The reason this exercise's API includes an explicit conversion to Vec<T> instead
// of IntoIterator is that implementing that interface is fairly complicated, and
// demands more of the student than we expect at this point in the track.

impl<T> From<SimpleLinkedList<T>> for Vec<T> {
    fn from(mut _linked_list: SimpleLinkedList<T>) -> Vec<T> {
        todo!()
    }
}
