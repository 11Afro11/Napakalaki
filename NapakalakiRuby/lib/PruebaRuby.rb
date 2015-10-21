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
badConsequence = BadConsequence.newLevelNumberOfTreasures("Toses los pulmones y pierdes 2 niveles")
monsters<< Monster.new("La que redacta las tinieblas",2, prize, badConsequence)

prize = Prize.new(1,1)
badConsequence = BadConsequence.newLevelSpecificTreasures("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 3, [TreasureKind::BOOTHHANDS], 0)
monsters<< Monster.new("Bicéfalo", 20, prize, badConsequence)