describe('Verificar valor', () => {
    it('valor igual a 2', () => {
        cy.request("GET", "http://localhost:8085/teste").as('TodoRequest');
        cy.get('@TodoRequest').then(response => {
            expect(response.body).to.eq(2);
        })
    })
})