#encoding: UTF-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require "singleton"
require_relative "Prize.rb"
require_relative "TreasureKind.rb"
require_relative "BadConsequence.rb"
require_relative "Monster.rb"
require_relative "cultist.rb"
require_relative "specific_bad_consecuence.rb"
require_relative "death_bad_consequence.rb"
require_relative "numeric_bad_consequence.rb"

module NapakalakiGame

	class CardDealer
		include Singleton
    
    attr_accessor :used_monster, :unused_monster, :used_treasures, :unused_treasures
    
    def initialize
      @unused_treasures = Array.new
      @used_treasures = Array.new
      @used_monster = Array.new
      @unused_monster = Array.new
      @unused_cultist = Array.new
      
    end
    
	def initTreasureCardDeck      
      @unused_treasures << Treasure.new("Si mi amo", 4, [TreasureKind::HELMET])
      @unused_treasures << Treasure.new("Botas de investigacion", 3, [TreasureKind::SHOES])
      @unused_treasures << Treasure.new("Capucha de Cthulhu", 3, [TreasureKind::HELMET])
      @unused_treasures << Treasure.new("A prueba de babas", 2, [TreasureKind::ARMOR])
      @unused_treasures << Treasure.new("Botas de lluvia acida", 1, [TreasureKind::BOTHHANDS])
      @unused_treasures << Treasure.new("Casco minero", 2, [TreasureKind::HELMET])
      @unused_treasures << Treasure.new("Ametralladora Thompson", 4, [TreasureKind::BOTHHANDS])
      @unused_treasures << Treasure.new("Camiseta de la UGR", 1, [TreasureKind::ARMOR])
      @unused_treasures << Treasure.new("Clavo del rail ferroviario", 3, [TreasureKind::ONEHAND])
      @unused_treasures << Treasure.new("Cuchillo de sushi arcano", 2, [TreasureKind::ONEHAND])
      @unused_treasures << Treasure.new("Fez alopodo", 3, [TreasureKind::HELMET])
      @unused_treasures << Treasure.new("Hacha prehistorica", 2, [TreasureKind::ONEHAND])
      @unused_treasures << Treasure.new("El aparato del Pr. Tesla", 4, [TreasureKind::ARMOR])
      @unused_treasures << Treasure.new("Gaita", 4, [TreasureKind::BOTHHANDS])
      @unused_treasures << Treasure.new("Insecticida", 2, [TreasureKind::ONEHAND])
      @unused_treasures << Treasure.new("Escopeta de 3 cañones", 4, [TreasureKind::BOTHHANDS])
      @unused_treasures << Treasure.new("Garabato mistico", 2, [TreasureKind::ONEHAND])
      @unused_treasures << Treasure.new("La rebeca metalica", 2, [TreasureKind::ARMOR])
      @unused_treasures << Treasure.new("Lanzallamas", 4, [TreasureKind::BOTHHANDS])
      @unused_treasures << Treasure.new("Necrocomicon", 1, [TreasureKind::ONEHAND])
      @unused_treasures << Treasure.new("Necronomicon", 5, [TreasureKind::BOTHHANDS])
      @unused_treasures << Treasure.new("Linterna a dos manos", 3, [TreasureKind::BOTHHANDS])
      @unused_treasures << Treasure.new("Necrognomicon", 2, [TreasureKind::ONEHAND])
      @unused_treasures << Treasure.new("Necrotelecom", 2, [TreasureKind::HELMET])
      @unused_treasures << Treasure.new("Mazo de los antiguos", 3, [TreasureKind::ONEHAND])
      @unused_treasures << Treasure.new("Necroplayboycon", 3, [TreasureKind::ONEHAND])
      @unused_treasures << Treasure.new("Porra preternatural", 2, [TreasureKind::ONEHAND])
      @unused_treasures << Treasure.new("Shogulador", 1, [TreasureKind::BOTHHANDS])
      @unused_treasures << Treasure.new("Varita de atizamiento", 3, [TreasureKind::ONEHAND])
      @unused_treasures << Treasure.new("Tentaculo de pega", 2, [TreasureKind::HELMET])
      @unused_treasures << Treasure.new("Zapato deja-amigos", 1, [TreasureKind::SHOES])
      
	end

	def initMonsterCardDeck
     
        prize = Prize.new(2,1)
        badConsequence = SpecificBadConsecuence.new("Pierdes tu armadura visible y otra oculta",  0,[TreasureKind::ARMOR],[TreasureKind::ARMOR])
        unused_monster<< Monster.new("Byakhees de bonanza", 8, prize, badConsequence, 0)

        prize = Prize.new(1,1)
        badConsequence = SpecificBadConsecuence.new("Embobados con el lindo primigenio te descartas de tu casco visible", 0, [TreasureKind::ARMOR], [])
        unused_monster<< Monster.new("Chibithulhu", 2, prize, badConsequence, 0)

        prize = Prize.new(1,1)
        badConsequence = SpecificBadConsecuence.new("El primordial bostezo contagioso. Pierdes el calzado visible", 0, [TreasureKind::SHOES], [])
        unused_monster<< Monster.new("El sopor de Dunwich", 2, prize, badConsequence, 0)

        prize = Prize.new(4,1)
        badConsequence = SpecificBadConsecuence.new("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta", 0, [TreasureKind::ONEHAND], [TreasureKind::ONEHAND])
        unused_monster<< Monster.new("Ángeles de la noche ibicenca", 14, prize, badConsequence, 0)

        prize = Prize.new(3,1)
        badConsequence = NumericBadConsequence.new("Pierdes todos los tesoros visibles", 0,5,0)
        unused_monster<< Monster.new("El gorrón en el umbral", 10, prize, badConsequence, 0)

        prize = Prize.new(2,1)
        badConsequence = SpecificBadConsecuence.new("Pierdes la armadura visible", 0, [TreasureKind::ARMOR], [])
        unused_monster<< Monster.new("H.P. Munchcraft", 6 , prize, badConsequence, 0)

        prize = Prize.new(1,1)
        badConsequence = SpecificBadConsecuence.new("Sientes bichos bajo la ropa. Descarta la armadura visible", 0, [TreasureKind::ARMOR], [])
        unused_monster<< Monster.new("Bichgooth",2,prize,badConsequence, 0)

        price = Prize.new(4,2) 
        badConsequence = NumericBadConsequence.new("Pierdes 5 niveles y 3 tesoros visibles",5 , 3, 0)
        unused_monster << Monster.new("El rey de rosa",13,prize,badConsequence, 0)

        prize = Prize.new(1,1)
        badConsequence = NumericBadConsequence.new("Toses los pulmones y pierdes 2 niveles",2, 0, 0)
        unused_monster<< Monster.new("La que redacta las tinieblas",2, prize, badConsequence, 0)

        prize = Prize.new(1,1)
        badConsequence = SpecificBadConsecuence.new("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 3, [TreasureKind::BOTHHANDS], [])
        unused_monster<< Monster.new("Bicéfalo", 20, prize, badConsequence, 0)

        #Los Hondos
        prize = Prize.new(2, 1)
        badConsequence = DeathBadConsequence.new("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto", )
        unused_monster<< Monster.new("Los hondos", 8, prize, badConsequence, 0)

        #Semillas Cthulhu
        prize = Prize.new(2, 1)
        badConsequence = NumericBadConsequence.new("Pierdes 2 niveles y dos tesoros ocultos", 2, 2, 0)
        unused_monster<< Monster.new("Semillas Cthulhu", 4, prize, badConsequence, 0)

        #Dameargo
        prize = Prize.new(2, 1)
        badConsequence = SpecificBadConsecuence.new("Te intentas escaquear. Pierdes una mano visible", 0, [TreasureKind::ONEHAND], [])
        unused_monster<< Monster.new("Dameargo", 1, prize, badConsequence, 0)

        #Pollipolipo Volante
        prize = Prize.new(1, 1)
        badConsequence = NumericBadConsequence.new("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0)
        unused_monster<< Monster.new("Pollipolipo Volante", 3, prize, badConsequence, 0)

        #Yskhtihyssg-Goth
        prize = Prize.new(3, 1)
        badConsequence = DeathBadConsequence.new("No le hace gracia que pronuncien mal su nombre. Estas muerto")
        unused_monster<< Monster.new("Yskhtihyssg-Goth", 12, prize, badConsequence, 0)

        #Familia Feliz
        prize = Prize.new(4, 1)
        badConsequence = DeathBadConsequence.new("La familia te atrapa. Estas muerto")
        unused_monster<< Monster.new("Familia Feliz", 1, prize, badConsequence, 0)

        #Roboggoth
        prize = Prize.new(2, 1)
        badConsequence = NumericBadConsequence.new("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visibles", 2, 2, 0)
        unused_monster<< Monster.new("Roboggoth", 8, prize, badConsequence, 0)

        #El Espia
        prize = Prize.new(1, 1)
        badConsequence = SpecificBadConsecuence.new("Te asusta en la noche. Pierdes un casco visible", 0, [TreasureKind::ONEHAND], [])
        unused_monster<< Monster.new("El Espia", 5, prize, badConsequence, 0)

        #El Lenguas
        prize = Prize.new(1, 1)
        badConsequence = NumericBadConsequence.new("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0)
        unused_monster<< Monster.new("El Lenguas", 20, prize, badConsequence, 0)
        
        #**********************************************************Monstruos con Sectarios**********************************************************#

        prize = Prize.new(3, 1)
        badConsequence = NumericBadConsequence.new("Pierdes una mano visible", 0, 2, 0)
        unused_monster << Monster.new("El mal indecible impronunciable", 10, prize, badConsequence, -2)

        prize = Prize.new(2, 1)
        badConsequence = SpecificBadConsecuence.new("Pierdes tus tesoros visibles. Jajaja", 0, nil, 0)
        unused_monster << Monster.new("Testigos Oculares", 6, prize, badConsequence, +2)

        prize = Prize.new(2, 5)
        badConsequence = DeathBadConsequence.new("Hoy no es tu dia de suerte. Mueres")
        unused_monster << Monster.new("El gran Cthulhu", 20, prize, badConsequence, +4)

        prize = Prize.new(2, 1)
        badConsequence = NumericBadConsequence.new("Tu gobierno te recorta 2 niveles", 2, 0, 0)
        unused_monster << Monster.new("Serpiente Politico", 8, prize, badConsequence, -2)

        prize = Prize.new(1, 1)
        badConsequence = SpecificBadConsecuence.new("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas", 0, [TreasureKind::HELMET, TreasureKind::ARMOR], nil)
        unused_monster << Monster.new("Felpuggoth", 2, prize, badConsequence, +5)

        prize = Prize.new(4, 2)
        badConsequence = NumericBadConsequence.new("Pierdes dos niveles", 2, 0, 0)
        unused_monster << Monster.new("Shoggoth", 16, prize, badConsequence, -4)

        prize = Prize.new(1, 1)
        badConsequence = NumericBadConsequence.new("Pintalabios negro. Pierdes 2 niveles", 2, 0, 0)
        unused_monster << Monster.new("Lolitagooth", 2, prize, badConsequence, +3)
	end

	def shuffleTreasures
      @unused_treasures = @unused_treasures.shuffle

	end
  
  def initCultistCardDeck
    @unused_cultist << Cultist.new("Sectario: +1 por cada sectario en juego. No puedes dejar de ser sectario.", 1)
    @unused_cultist << Cultist.new("Sectario: +2 por cada sectario en juego. No puedes dejar de ser sectario.", 2)
    @unused_cultist << Cultist.new("Sectario: +1 por cada sectario en juego. No puedes dejar de ser sectario.", 1)
    @unused_cultist << Cultist.new("Sectario: +2 por cada sectario en juego. No puedes dejar de ser sectario.", 2)
    @unused_cultist << Cultist.new("Sectario: +1 por cada sectario en juego. No puedes dejar de ser sectario.", 1)
    @unused_cultist << Cultist.new("Sectario: +1 por cada sectario en juego. No puedes dejar de ser sectario.", 1)
  end

	def shuffleMonster
      @unused_monster = @unused_monster.shuffle

	end
  
  def shuffleCultist
    @unused_cultist = @unused_cultist.shuffle
  end

	def getInstance
		@instance
	end

	def nextTreasure
      if @unused_treasures.nil?
        @used_treasures.each do |t|
          @unused_treasures<<t
        end

	      shuffleTreasures
	      @used_treasure.clear
      end
      t = @unused_treasures.at(0)
      @used_treasures<<t
      @unused_treasures.delete(t)
      return t

	end

	def nextMonster
      if @unused_monster.nil?
        @used_monster.each do |m|
         	@unused_monster<<m
        end
        	shuffleMonster
        	@used_monster.clear
      end

	  m = @unused_monster.at(0)
	  @unused_monster.delete(m)
	  @used_monster<<m

      return m

	end

	def giveTreasureBack(treasure)
		if !used_treasures.include?
      		@used_treasures << treasure
      	end
	end

	def giveMonsterBack(monster)
		if !used_monster.include?
      		@used_monster << monster
      	end
	end

	def initCards
	    initTreasureCardDeck
	    shuffleTreasures
	    
	    initMonsterCardDeck
	    shuffleMonster
      
    initCultistCardDeck
    shuffleCultist
	end
  end
end