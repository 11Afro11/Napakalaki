# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

monsters = Array.new

prize = Prize.new(2, 1)
badConsequence = BadConsequence.newLevelSpecificTreasures("Pierdes tu armadura visible y otra oculta",  0,[TreasureKind::ARMOR],[TreasureKind::ARMOR])
monsters<< Monster.new('Byakhees de bonanza', 8, prize, badConsequence)

prize = Prize.new(1,1)
badConsequence = BadConsequence.newLevelSpecificTreasures("Embobados con el lindo primigenio te descartas de tu casco visible", 0, [TreasureKind::Armor], 0)
monsters<< Monster.new("Chibithulhu", 2, prize, badConsequence)

prize = Prize.new(1,1)
badConsequence = BadConsequence.newLevelSpecificTreasures("El primordial bostezo contagioso. Pierdes el calzado visible", 0, [TreasureKind::SHOES], 0)
monsters<< Monster.new("El sopor de Dunwich", 2, prize, badConsequence)

prize = Prize.new(4,1)
badConsequence = BadConsequence.newLevelSpecificTreasures("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta", 0, [TreasureKind::ONEHAND], [TreasureKind::ONEHAND])
monsters<< Monster.new("Ángeles de la noche ibicenca", 14, prize, badConsequence)

prize = Prize.new(3,1)
badConsequence = bas_consequence.newLevelNumbreOfTreasures("Pierdes todos los tesoros visibles", 0,5,0)
monsters<< Monster.new("El gorrón en el umbral", 10, prize, badConsequence)

prize = Prize.new(2,1)
badConsequence = BadConsequence.newLevelSpecificTreasures("Pierdes la armadura visible", 0, [TreasureKind::ARMOR], 0)
monsters<< Monster.new("H.P. Munchcraft", 6 , prize, badConsequence)

prize = Prize.new(1,1)
badConsequence = BadConsequence.newLevelSpecificTreasures("Sientes bichos bajo la ropa. Descarta la armadura visible", 0, [TreasureKind::ARMOR], 0)
monsters<< Monster.new("Bichgooth",2,prize,badConsequence)

price = Prize.new(4,2) 
badConsequence = BadConsequence.newLevelNumberOfTreasures('Pierdes 5 niveles y 3 tesoros visibles',5 , 3, 0)
monsters << Monster.new('El rey de rosa',13,prize,badConsequence)

prize = Prize.new(1,1)
badConsequence = BadConsequence.newLevelNumberOfTreasures("Toses los pulmones y pierdes 2 niveles",2, 0, 0)
monsters<< Monster.new("La que redacta las tinieblas",2, prize, badConsequence)

prize = Prize.new(1,1)
badConsequence = BadConsequence.newLevelSpecificTreasures("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 3, [TreasureKind::BOOTHHANDS], 0)
monsters<< Monster.new("Bicéfalo", 20, prize, badConsequence)

#Los Hondos
prize = Prize.new(2, 1)
badConsequence = BadConsequence.newLevelNumberOfTreasures("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto", true)
mosnters<< Monster.new("Los hondos", 8, prize, badConsequence)

#Semillas Cthulhu
prize = Prize.new(2, 1)
badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes 2 niveles y dos tesoros ocultos", 2, 2, 0)
monster<< Monster.new("Semillas Cthulhu", 4, prize, badConsequence)

#Dameargo
prize = Prize.new(2, 1)
badConsequence = BadConsequence.newLevelSpecificTreasures("Te intentas escaquear. Pierdes una mano visible", 0, [TreasureKind::HAND], 0)
monsters<< Monster.new("Dameargo", 1, prize, badConsequence)

#Pollipolipo Volante
prize = Prize.new(1, 1)
badConsequence = BadConsequence.newLevelNumberOfTreasures("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0)
monsters<< Monster.new("Pollipolipo Volante", 3, prize, badConsequence)

#Yskhtihyssg-Goth
prize = Prize.new(3, 1)
badConsequence = BadConsequence.newLevelOfTreasures("No le hace gracia que pronuncien mal su nombre. Estas muerto", true)
monsters<< Monster.new("Yskhtihyssg-Goth", 12, prize, badConsequence)

#Familia Feliz
prize = Prize.new(4, 1)
badConsequence = BadConsequence.newLevelOfTreasures("La familia te atrapa. Estas muerto", true)
monsters<< Monster.new("Familia Feliz", 1, prize, badConsequence)

#Roboggoth
prize = Prize.new(2, 1)
badConsequence = BadConsequence.newLevelOfTreasures("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visibles", 2, 2, 0)
monsters<< Monster.new("Roboggoth", 8, prize, badConsequence)

#El Espia
prize = Prize.new(1, 1)
badConsequence = BadConsequence.newLevelSpecificTreasures("Te asusta en la noche. Pierdes un casco visible", 0, [TreasureKind::HAND], 0)
monsters<< Monster.new("El Espia", 5, price, badConsequence)

#El Lenguas
prize = Prize.new(1, 1)
badConsequence = BadConsequence.newLevelOfTreasures("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0)
monsters<< Monster.new("El Lenguas", 20, price, badConsequence)


