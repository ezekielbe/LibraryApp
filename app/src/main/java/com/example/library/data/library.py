# library.py
from flask import Flask, jsonify
import json

app = Flask(__name__)

# Load book data from books.json
def load_books():
    with open('books.json') as f:
        return json.load(f)

books = load_books()

@app.route('/books', methods=['GET'])
def get_books():
    return jsonify(books), 200

@app.route('/books/<int:book_id>', methods=['GET'])
def get_book(book_id):
    book = next((book for book in books if book["id"] == book_id), None)
    if book is not None:
        return jsonify(book), 200
    else:
        return jsonify({"message": "Book not found"}), 404

if __name__ == '__main__':
    app.run(host="0.0.0.0", port="8888",debug=True)
