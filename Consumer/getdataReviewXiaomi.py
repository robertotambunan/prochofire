import requests, json
import MySQLdb
import sys

response = requests.get('https://api.bukalapak.com/v2/products/1vryu1/reviews.json?page=31')

assert response.status_code == 200

data = response.json()

#print json.dumps(data)


connection = MySQLdb.connect (host = "127.0.0.1", user = "root", passwd = "", db = "bukalapak")
# prepare a cursor object using cursor() method
cursor = connection.cursor ()

for i in range(0, 5):
	#print data["reviews"][i]["id"]
	#print data["reviews"][i]["sender_id"]
	#print data["reviews"][i]["sender_name"]
	#print data["reviews"][i]["sender_type"]
	#print data["reviews"][i]["rate"]
	#print data["reviews"][i]["updated_at"]
	#print data["reviews"][i]["positive_votes"]	
	#print data["reviews"][i]["negative_votes"]
	#print data["reviews"][i]["product"]
	#print data["reviews"][i]["user_vote"]
	#print ""

	ids_product = "1vryu1"
	
	try:
		cursor.execute("""INSERT IGNORE into reviews (id, sender_id, sender_name, sender_type, rate, body, updated_at, positive_votes, negative_votes, product, user_vote, product_id) VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)""",((data["reviews"][i]["id"],data["reviews"][i]["sender_id"],data["reviews"][i]["sender_name"],data["reviews"][i]["sender_type"],data["reviews"][i]["rate"],data["reviews"][i]["body"],data["reviews"][i]["updated_at"],data["reviews"][i]["positive_votes"],data["reviews"][i]["negative_votes"],data["reviews"][i]["product"],data["reviews"][i]["user_vote"], ids_product)))
		connection.commit()
	except MySQLdb.Error as e:
		print e
		print "failed"








