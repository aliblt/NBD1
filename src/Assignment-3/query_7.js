printjson( db.people.remove({height: {$gt: "190"}}) )
printjson( db.people.findOne({ height: {$gt: "190"} }) )