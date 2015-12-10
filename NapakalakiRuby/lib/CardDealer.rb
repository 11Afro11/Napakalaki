#encoding: UTF-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "Prize.rb"
require_relative "TreasureKind.rb"
require_relative "BadConsequence.rb"
require_relative "Monster.rb"

module NapakalakiGame
  require "singleton"
	class CardDealer
		include Singleton
    
    attr_accessor :used_monsters, :unused_monsters, :used_treasures, :unused_treasures
    
    def initialize
      @unused_treasures = Array.new
      @used_treasures = Array.new
      @used_monster = Array.new
      @unused_monster = Array.new
    end
    
		def initTreasureCardDeck
      
      
      @unsused_treasures << Treasure.new("Si mi amo", 4, [TreasureKind::HELMET])
      @unsused_treasures << Treasure.new("Botas de investigacion", 3, [TreasureKind::SHOES])
      @unsused_treasures << Treasure.new("Capucha de Cthulhu", 3, [TreasureKind::HELMET])
      @unsused_treasures << Treasure.new("A prueba de babas", 2, [TreasureKind::ARMOR])
      @unsused_treasures << Treasure.new("Botas de lluvia acida", 1, [TreasureKind::BOTHHANDS])
      @unsused_treasures << Treasure.new("Casco minero", 2, [TreasureKind::HELMET])
      @unsused_treasures << Treasure.new("Ametralladora Thompson", 4, [TreasureKind::BOTHHANDS])
      @unsused_treasures << Treasure.new("Camiseta de la UGR", 1, [TreasureKind::ARMOR])
      @unsused_treasures << Treasure.new("Clavo del rail ferroviario", 3, [TreasureKind::ONEHAND])
      @unsused_treasures << Treasure.new("Cuchillo de sushi arcano", 2, [TreasureKind::ONEHAND])
      @unsused_treasures << Treasure.new("Fez alopodo", 3, [TreasureKind::HELMET])
      @unsused_treasures << Treasure.new("Hacha prehistorica", 2, [TreasureKind::ONEHAND])
      @unsused_treasures << Treasure.new("El aparato del Pr. Tesla", 4, [TreasureKind::ARMOR])
      @unsused_treasures << Treasure.new("Gaita", 4, [TreasureKind::BOTHHANDS])
      @unsused_treasures << Treasure.new("Insecticida", 2, [TreasureKind::ONEHAND])
      @unsused_treasures << Treasure.new("Escopeta de 3 cañones", 4, [TreasureKind::BOTHHANDS])
      @unsused_treasures << Treasure.new("Garabato mistico", 2, [TreasureKind::ONEHAND])
      @unsused_treasures << Treasure.new("La rebeca metalica", 2, [TreasureKind::ARMOR])
      @unsused_treasures << Treasure.new("Lanzallamas", 4, [TreasureKind::BOTHHANDS])
      @unsused_treasures << Treasure.new("Necrocomicon", 1, [TreasureKind::ONEHAND])
      @unsused_treasures << Treasure.new("Necronomicon", 5, [TreasureKind::BOTHHANDS])
      @unsused_treasures << Treasure.new("Linterna a dos manos", 3, [TreasureKind::BOTHHANDS])
      @unsused_treasures << Treasure.new("Necrognomicon", 2, [TreasureKind::ONEHAND])
      @unsused_treasures << Treasure.new("Necrotelecom", 2, [TreasureKind::HELMET])
      @unsused_treasures << Treasure.new("Mazo de los antiguos", 3, [TreasureKind::ONEHAND])
      @unsused_treasures << Treasure.new("Necroplayboycon", 3, [TreasureKind::ONEHAND])
      @unsused_treasures << Treasure.new("Porra preternatural", 2, [TreasureKind::ONEHAND])
      @unsused_treasures << Treasure.new("Shogulador", 1, [TreasureKind::BOTHHANDS])
      @unsused_treasures << Treasure.new("Varita de atizamiento", 3, [TreasureKind::ONEHAND])
      @unsused_treasures << Treasure.new("Tentaculo de pega", 2, [TreasureKind::HELMET])
      @unsused_treasures << Treasure.new("Zapato deja-amigos", 1, [TreasureKind::SHOES])
      
		end

		def initMonsterCardDeck
      @unused_monsters = Array.new
     
       prize = Prize.new(2,1)
        badConsequence = BadConsequence.newLevelSpecificTreasures("Pierdes tu armadura visible y otra oculta",  0,[TreasureKind::ARMOR],[TreasureKind::ARMOR])
        unused_monsters<< Monster.new("Byakhees de bonanza", 8, prize, badConsequence)

        prize = Prize.new(1,1)
        badConsequence = BadConsequence.newLevelSpecificTreasures("Embobados con el lindo primigenio te descartas de tu casco visible", 0, [TreasureKind::ARMOR], [])
        unused_monsters<< Monster.new("Chibithulhu", 2, prize, badConsequence)

        prize = Prize.new(1,1)
        badConsequence = BadConsequence.newLevelSpecificTreasures("El primordial bostezo contagioso. Pierdes el calzado visible", 0, [TreasureKind::SHOES], [])
        unused_monsters<< Monster.new("El sopor de Dunwich", 2, prize, badConsequence)

        prize = Prize.new(4,1)
        badConsequence = BadConsequence.newLevelSpecificTreasures("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta", 0, [TreasureKind::ONEHAND], [TreasureKind::ONEHAND])
        unused_monsters<< Monster.new("Ángeles de la noche ibicenca", 14, prize, badConsequence)

        prize = Prize.new(3,1)
        badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes todos los tesoros visibles", 0,5,0)
        unused_monsters<< Monster.new("El gorrón en el umbral", 10, prize, badConsequence)

        prize = Prize.new(2,1)
        badConsequence = BadConsequence.newLevelSpecificTreasures("Pierdes la armadura visible", 0, [TreasureKind::ARMOR], [])
        unused_monsters<< Monster.new("H.P. Munchcraft", 6 , prize, badConsequence)

        prize = Prize.new(1,1)
        badConsequence = BadConsequence.newLevelSpecificTreasures("Sientes bichos bajo la ropa. Descarta la armadura visible", 0, [TreasureKind::ARMOR], [])
        unused_monsters<< Monster.new("Bichgooth",2,prize,badConsequence)

        price = Prize.new(4,2) 
        badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes 5 niveles y 3 tesoros visibles",5 , 3, 0)
        unused_monsters << Monster.new("El rey de rosa",13,prize,badConsequence)

        prize = Prize.new(1,1)
        badConsequence = BadConsequence.newLevelNumberOfTreasures("Toses los pulmones y pierdes 2 niveles",2, 0, 0)
        unused_monsters<< Monster.new("La que redacta las tinieblas",2, prize, badConsequence)

        prize = Prize.new(1,1)
        badConsequence = BadConsequence.newLevelSpecificTreasures("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 3, [TreasureKind::BOTHHANDS], [])
        unused_monsters<< Monster.new("Bicéfalo", 20, prize, badConsequence)

        #Los Hondos
        prize = Prize.new(2, 1)
        badConsequence = BadConsequence.newDeath("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto")
        unused_monsters<< Monster.new("Los hondos", 8, prize, badConsequence)

        #Semillas Cthulhu
        prize = Prize.new(2, 1)
        badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes 2 niveles y dos tesoros ocultos", 2, 2, 0)
        unused_monsters<< Monster.new("Semillas Cthulhu", 4, prize, badConsequence)

        #Dameargo
        prize = Prize.new(2, 1)
        badConsequence = BadConsequence.newLevelSpecificTreasures("Te intentas escaquear. Pierdes una mano visible", 0, [TreasureKind::ONEHAND], [])
        unused_monsters<< Monster.new("Dameargo", 1, prize, badConsequence)

        #Pollipolipo Volante
        prize = Prize.new(1, 1)
        badConsequence = BadConsequence.newLevelNumberOfTreasures("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0)
        unused_monsters<< Monster.new("Pollipolipo Volante", 3, prize, badConsequence)

        #Yskhtihyssg-Goth
        prize = Prize.new(3, 1)
        badConsequence = BadConsequence.newDeath("No le hace gracia que pronuncien mal su nombre. Estas muerto")
        unused_monsters<< Monster.new("Yskhtihyssg-Goth", 12, prize, badConsequence)

        #Familia Feliz
        prize = Prize.new(4, 1)
        badConsequence = BadConsequence.newDeath("La familia te atrapa. Estas muerto")
        unused_monsters<< Monster.new("Familia Feliz", 1, prize, badConsequence)

        #Roboggoth
        prize = Prize.new(2, 1)
        badConsequence = BadConsequence.newLevelNumberOfTreasures("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visibles", 2, 2, 0)
        unused_monsters<< Monster.new("Roboggoth", 8, prize, badConsequence)

        #El Espia
        prize = Prize.new(1, 1)
        badConsequence = BadConsequence.newLevelSpecificTreasures("Te asusta en la noche. Pierdes un casco visible", 0, [TreasureKind::ONEHAND], [])
        unused_monsters<< Monster.new("El Espia", 5, prize, badConsequence)

        #El Lenguas
        prize = Prize.new(1, 1)
        badConsequence = BadConsequence.newLevelNumberOfTreasures("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0)
        unused_monsters<< Monster.new("El Lenguas", 20, prize, badConsequence)
		end

		def shuffleTreasures
      @unused_treasures = @unused_treasures.shuffle

		end

		def shuffleMonster
      @unused_monsters = @unused_monsters.shuffle

		end

		def getInstance
			@instance
		end

		def nextTreasure
      if @unused_treasures.empty?
        @used_treasure.each do |t|4
          @unused_treasures<<t
        end

      shuffleTreasures
      @used_treasure.clear
      end
      t = @unused_treasures.at(0)
      #@used_treasure<<t@unused_treasures.delete(t)
      return t

		end

		def nextMonster
      if @unused_monsters.empty?
        @used_monsters.each do |m|
          @unused_monsters<<m
        end
        shuffleMonster
        @used_monsters.clear
      end

      m = @unused_monsters.at(0)
      @used_monsters<<m
      @unused_monsters.delete(m)

      return m

		end

		def giveTreasureBack(treasure)
      @used_treasure << treasure

		end

		def giveMonsterBack(monster)
      @used_monsters << monster

		end

		def initCards
			
		end
  end
end