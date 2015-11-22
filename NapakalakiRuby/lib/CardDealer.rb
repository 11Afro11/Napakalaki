# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module Napakalaki
	require "singleton"

	class CardDealer
		include Singleton
    
    attr_accesor :used_monsters, :unused_monsters, :used_treasures, :unused_treasures
    
		def initTreasureCardDeck
      @unused_treasures = Array.new
      @used_treasures = Array.new
		end

		def initMonsterCardDeck

		end

		def shuffleTreasures

		end

		def shuffleMonster

		end

		def getInstance
			@instance
		end

		def nextTreasure

		end

		def nextMonster

		end

		def giveTreasureBack(treasure)

		end

		def giveMonsterBack(monster)

		end

		def initCards
			
		end
  end
end