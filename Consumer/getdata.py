import requests, json

response = requests.get('https://api.bukalapak.com/v2/products.json?keywords=nikon&conditions=new&page=1&per_page=1')

assert response.status_code == 200

data = response.json()

#print json.dumps(data)


print data["products"][0]["name"]
print data["products"][0]["id"]
print data["products"][0]["rating"]["average_rate"]
print data["products"][0]["rating"]["user_count"]
print data["products"][0]["weight"]
print data["products"][0]["seller_id"]
print data["products"][0]["seller_avatar"]
print data["products"][0]["updated_at"]
print data["products"][0]["seller_positive_feedback"] 
print data["products"][0]["images"][0]
#print data["products"][0]["specs"]["kapasitas_memory"]
#print data["products"][0]["specs"]["brand"]
#print data["products"][0]["specs"]["screen_size"]
#print data["products"][0]["specs"]["kapasitas_hardisk"]
print data["products"][0]["category"]
print data["products"][0]["price"]
print data["products"][0]["weight"]
print data["products"][0]["desc"]
print data["products"][0]["url"]
print data["products"][0]["stock"]
