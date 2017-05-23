import requests, json
import MySQLdb
import sys

response = requests.get('https://api.bukalapak.com/v2/products/1vryu1.json')

assert response.status_code == 200

data = response.json()

#print json.dumps(data)


#print data["product"]["name"]
#print data["product"]["id"]
#print data["product"]["rating"]["average_rate"]
#print data["product"]["rating"]["user_count"]
#print data["product"]["weight"]
#print data["product"]["seller_id"]
#print data["product"]["seller_avatar"]
#print data["product"]["updated_at"]
#print data["product"]["seller_positive_feedback"] 
#print data["product"]["images"][0]
#print data["products"][0]["specs"]["kapasitas_memory"]
#print data["products"][0]["specs"]["brand"]
#print data["products"][0]["specs"]["screen_size"]
#print data["products"][0]["specs"]["kapasitas_hardisk"]
#print data["product"]["category"]
#print data["product"]["price"]
#print data["product"]["weight"]
#print data["product"]["desc"]
#print data["product"]["url"]
#print data["product"]["stock"]



print data["product"]["id"]
print data["product"]["name"]
print data["product"]["city"]
print data["product"]["province"]
print data["product"]["weight"]
print data["product"]["images"][0]
print data["product"]["small_images"][0]
print data["product"]["desc"]
print data["product"]["condition"]
print data["product"]["stock"]
print data["product"]["favorited"]
print data["product"]["created_at"]
print data["product"]["updated_at"]
print data["product"]["seller_username"]
print data["product"]["seller_name"]
print data["product"]["seller_id"]
print data["product"]["seller_avatar"]
print data["product"]["seller_level"]
print data["product"]["seller_level_badge_url"]
print data["product"]["seller_delivery_time"]
print data["product"]["seller_positive_feedback"]
print data["product"]["seller_negative_feedback"]
print data["product"]["seller_term_condition"]
print data["product"]["top_merchant"]





connection = MySQLdb.connect (host = "127.0.0.1", user = "root", passwd = "", db = "bukalapak")
# prepare a cursor object using cursor() method
cursor = connection.cursor ()

try:
	#Execute the SQL command
    cursor.execute("""INSERT into products (id, products.name, city, province, weight, images, small_images, description , products.condition, stock, favorited, created_at, updated_at, seller_username, seller_name, seller_id, seller_avatar, seller_level, seller_level_badge_url, seller_delivery_time, seller_positive_feedback, seller_negative_feedback, seller_term_condition, top_merchant) VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)""",((data["product"]["id"],data["product"]["name"],data["product"]["city"],data["product"]["province"],data["product"]["weight"],data["product"]["images"][0],data["product"]["small_images"][0],data["product"]["desc"],data["product"]["condition"],data["product"]["stock"],data["product"]["favorited"],data["product"]["created_at"],data["product"]["updated_at"],data["product"]["seller_username"],data["product"]["seller_name"],data["product"]["seller_id"],data["product"]["seller_avatar"],data["product"]["seller_level"],data["product"]["seller_level_badge_url"],data["product"]["seller_delivery_time"],data["product"]["seller_positive_feedback"],data["product"]["seller_negative_feedback"],data["product"]["seller_term_condition"],data["product"]["top_merchant"])))
    # Commit your changes in the database
    connection.commit()
except MySQLdb.Error as e:
	print e
	print "gagal"