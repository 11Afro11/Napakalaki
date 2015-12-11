# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "CardDealer.rb"
require_relative "Player.rb"
require "singleton"
module NapakalakiGame
class Napakalaki
	include Singleton

	attr_accessor :currentPlayer, :currentMonster, :players, :carddealer

	def initialize
      
      @players = Array.new
      @carddealer = CardDealer.instance
      @firstPlayer = true
      @currentPlayer = nil
      @currentMonster = Monster.new("", 0, Prize.new(0, 0),
        BadConsequence.newLevelNumberOfTreasures("", 0, 0, 0))
      @currentPlayerIndex = -1
    end
   
  def copia(p)
      @name = p.name
      @level = p.level
      @dead = p.dead
      @canSteal = p.canSteal
      @enemy = p.enemy
      @hiddenTreasures =p.hiddenTreasures
      @visibleTreasures = p.visibleTreasures
      @badStuff = p.badStuff
    end

	def initPlayers(names)
		names.each do |s|
			puts s
			@players<<Player.new(s)
		end
	end

	def nextPlayer
		total_p = @players.length

		if(@currentPlayerIndex == -1)
			@currentPlayerIndex = rand(total_p)
	    else
			@currentPlayerIndex = (@currentPlayerIndex +1) % total_p
			
		end
		@currentPlayer = @players.at(@currentPlayerIndex)
      
		return @currentPlayer
 	end

	def nextTurnAllowed
		if (@currentPlayer == nil) then
			allowed = true
		else
			allowed =@currentPlayer.validState
		end
		return allowed
		
	end

	def setEnemies
    r = 0
    @players.each do |p|
      begin
        r = rand(@players.length)
      end while(r == @players.index(p))
      p.setEnemy(@players.at(r))
    end
		
	end

	def developCombat
		m = @currentMonster;
		myLevel = @currentPlayer.getCombatLevel()
		monsterLevel = @currentMonster.getCombatLevel()
    
    	combat = @currentPlayer.combat(m)
    	return combat
    
	end

	def discardVisibleTreasure(treasure)
		treasure.each do |t|
			@currentPlayer.discardVisibleTreasures(t)
			@carddealer.giveTreasureBack(t)
		end		
	end

	def discardHiddenTreasure(treasure)
		treasure.each do |t|
			@currentPlayer.discardHiddenTreasure(t)
			@carddealer.giveTreasureBack(t)
		end		
	end

	def makeTreasuresVisible(treasure)
		treasure.each do |t|
			@currentPlayer.makeTreasuresVisible(t)
		end
	end

	def initGame(players)
		initPlayers(players)
    setEnemies
		@carddealer.initCards
		nextTurn				
	end

	def getCurrentPlayer
		return @currentPlayer
		
	end

	def getCurrentMonster
		return @currentMonster
		
	end

	def nextTurn
		allowed = nextTurnAllowed

		if allowed
			@currentMonster = @carddealer.nextMonster
			@currentPlayer = nextPlayer
			dead = @currentPlayer.isDead
			if dead
				@currentPlayer.initTreasure
			end
		end
		return allowed
	end

	def endOfGame
		return result = WINGAME
		
	end
end
end
