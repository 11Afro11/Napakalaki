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
      @indice_jugador = 0;
      @currentPlayer = Player.new("")
      @currentMonster = Monster.new("", 0, Prize.new(0, 0),
        BadConsequence.newLevelNumberOfTreasures("", 0, 0, 0))
    end

	def initPlayers(names)
		@players = Array.new
		names.each do |s|
			players<<Player.new(s)
		end

	end

	def nextPlayer
		total_p = @players.length

		if(@currentPlayer == nil) then
			next_index = rand(total_p)
		
	  end
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
		total_players = @players.length
		enemie = rand(total_players)
		
	end

	def developCombat
		m = @currentMonster;
		myLevel = @currentPlayer.getCombatLevel()
		monsterLevel = @currentMonster.getCombatLevel();

		if myLevel > monsterLevel then
			@currentMonster.getPrize()
			combat = WIN
		else
			@currentMonster.getBc()
			combat = LOSE
		end
	end

	def discardVisibleTreasures(treasure)
		treasure.each do |t|
			@currentPlayer.discardVisibleTreasures(t)
			@carddealer.giveTreasureBack(t)
		end		
	end

	def discardHiddenTreasures(treasure)
		treasure.each do |t|
			@currentPlayer.discardHiddenTreasures(t)
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
		carddealer.initCards
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

		if allowed then
			@currentMonster = @carddealer.nextMonster
			@currentPlayer = @carddealer.nextPlayer
			dead = @currentPlayer.isDead
			if dead then
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
