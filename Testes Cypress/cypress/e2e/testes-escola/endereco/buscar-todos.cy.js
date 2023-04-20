describe("Buscar Todos Endereços", () => {
    it('Retorna lista com todos endereços', () => {
        cy.request("GET", "http://localhost:8085/endereco").as("BuscarTodosRequest");
        cy.get('@BuscarTodosRequest').then(response => {
            expect(response.body).to.be.a("array")
        })
    })
})