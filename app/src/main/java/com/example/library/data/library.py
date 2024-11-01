# library.py
from flask import Flask, jsonify
from pymongo import MongoClient
import json

app = Flask(__name__)

client = MongoClient("mongodb+srv://csis4280theone:dXX3FFJbTLr7zSlg@cluster0.enal4.mongodb.net/csis4280theone?retryWrites=true&w=majority")

db = client.csis4280theone
users_collection = db.users
books_collection = db.books

# Fetch books
@app.route('/books', methods=['GET'])
def get_books():
    try:
        books = books_collection.find({}, {
             "_id": 0, "id": 1, "title": 1, "author": 1, "genre": 1, "description": 1, 
            "quantity": 1, "available": 1
        })
        book_list = list(books)
        return jsonify(book_list), 200
    except Exception as e:
        return jsonify({"error": str(e)}), 500

@app.route('/books/<int:book_id>', methods=['GET'])
def get_book(book_id):
    # TODO update serach function instead of get all books
    books = books_collection.find({}, {
            "_id": 0, "id": 1, "title": 1, "author": 1, "genre": 1, "description": 1, 
        "quantity": 1, "available": 1
    })
    book = next((book for book in books if book["id"] == book_id), None)
    if book is not None:
        return jsonify(book), 200
    else:
        return jsonify({"message": "Book not found"}), 404

if __name__ == '__main__':
    app.run(host="0.0.0.0", port="8888",debug=True)
