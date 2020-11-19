printjson(
    db.people.aggregate(
        {
            $group: {
                _id: null,
                "Unique Jobs": {$addToSet: "$job"}
            }
        }
    ).toArray()
);