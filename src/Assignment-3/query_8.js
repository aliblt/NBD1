printjson( db.people.updateMany({"location.city": "Moscow"}, { $set: { "location.city": "Moskwa"} }) )
printjson( db.people.findOne({ "location.city": "Moskwa" }) )
printjson( db.people.findOne({ "location.city": "Moscow" }) )