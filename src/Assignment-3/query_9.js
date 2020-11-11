db.people.updateMany( { first_name: "Antonio" }, { $set: { hobby: "table tennis" } } )
printjson(db.people.find( { first_name: "Antonio" }).toArray())