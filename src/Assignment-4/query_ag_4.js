printjson(
    db.people.aggregate(
        {
            $group: {
                _id: "$nationality",
                "Minimum BMI": {
                    $min: {
                        $divide: [ {$toDouble: "$weight"}, {
                            $pow: [{$divide: [{$toDouble:"$height"}, 100]}, 2]
                        }]
                    }},
                "Maximum BMI": {
                    $max: {
                        $divide: [ {$toDouble: "$weight"}, {
                            $pow: [{$divide: [{$toDouble:"$height"}, 100]}, 2]
                        }]
                    }},
                "Average BMI": {
                    $avg: {
                        $divide: [ {$toDouble: "$weight"}, {
                            $pow: [{$divide: [{$toDouble:"$height"}, 100]}, 2]
                        }]
                    }}
            }
        }
    ).toArray()
);